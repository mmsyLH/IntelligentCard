package asia.lhweb.IntelligentCard.Interceptor;

import asia.lhweb.IntelligentCard.annotation.DeleteMarker;
import asia.lhweb.IntelligentCard.annotation.Entity;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Field;
import java.util.Properties;

/**
 * 自定义拦截器，用于将物理删除操作转换为逻辑删除操作。
 */
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
public class LogicalDeleteInterceptor implements Interceptor {

    /**
     * 当拦截到更新操作时，检查是否为删除操作并修改SQL为逻辑删除。
     *
     * @param invocation 提供了调用目标对象方法的能力的Invocation对象。
     * @return 返回调用结果，即更新后的MappedStatement。
     * @throws Throwable 抛出异常时，会由MyBatis的异常处理机制处理。
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 获取MappedStatement和参数
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        Object parameter = invocation.getArgs()[1];

        // 参数检查
        if (mappedStatement == null) {
            throw new IllegalArgumentException("MappedStatement 为空");
        }
        if (parameter == null) {
            throw new IllegalArgumentException("参数为空");
        }
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);
        if (boundSql == null) {
            throw new IllegalArgumentException("BoundSql 为空");
        }
        String sql = boundSql.getSql();

        // 检查是否为删除操作
        if (isDeleteOperation(sql)) {
            // 获取实体类和删除标记列信息
            Class<?> entityClass = getEntityClass(mappedStatement);
            String deleteMarkerColumn = getDeleteMarkerColumnName(entityClass);
            String[] deleteMarkerValues = getDeleteMarkerValues(entityClass);

            // 修改SQL为逻辑删除
            String updatedSql = updateSql(sql, deleteMarkerColumn, deleteMarkerValues);

            // 创建新的MappedStatement
            MappedStatement newMs = copyFromMappedStatement(mappedStatement, updatedSql);
            invocation.getArgs()[0] = newMs;
        }

        // 继续执行原有方法
        return invocation.proceed();
    }

    /**
     * 判断SQL语句是否为删除操作。
     *
     * @param sql 待检查的SQL语句。
     * @return 如果是删除操作则返回true，否则返回false。
     */
    private boolean isDeleteOperation(String sql) {
        return sql.toUpperCase().startsWith("DELETE");
    }

    /**
     * 根据MappedStatement获取对应的实体类。
     *
     * @param mappedStatement MappedStatement对象。
     * @return 返回实体类的Class对象。
     * @throws IllegalArgumentException 当无法找到实体类时抛出。
     */
    private Class<?> getEntityClass(MappedStatement mappedStatement) {
        String id = mappedStatement.getId();
        String className = id.substring(0, id.lastIndexOf("."));
        Class<?> mapperClass;
        try {
            mapperClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("找不到 Mapper 类", e);
        }

        Entity entityAnnotation = mapperClass.getAnnotation(Entity.class);
        if (entityAnnotation != null) {
            return entityAnnotation.value();
        } else {
            throw new IllegalArgumentException("找不到实体类");
        }
    }

    /**
     * 获取删除标记列的名称。
     *
     * @param entityClass 实体类的Class对象。
     * @return 返回删除标记列的名称。
     * @throws IllegalArgumentException 当无法找到删除标记注解时抛出。
     */
    private String getDeleteMarkerColumnName(Class<?> entityClass) {
        Field[] fields = entityClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(DeleteMarker.class)) {
                return field.getAnnotation(DeleteMarker.class).columnName();
            }
        }
        return "is_delete"; // 默认列名为 is_delete
    }

    /**
     * 获取删除标记的活动值和删除值。
     *
     * @param entityClass 实体类的Class对象。
     * @return 返回一个包含活动值和删除值的字符串数组。
     */
    private String[] getDeleteMarkerValues(Class<?> entityClass) {
        Field[] fields = entityClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(DeleteMarker.class)) {
                DeleteMarker deleteMarkerAnnotation = field.getAnnotation(DeleteMarker.class);
                return new String[]{String.valueOf(deleteMarkerAnnotation.activeValue()), String.valueOf(deleteMarkerAnnotation.deletedValue())};
            }
        }
        return new String[]{"0", "1"};
    }

    /**
     * 将物理删除SQL修改为逻辑删除SQL。
     *
     * @param sql 原始SQL语句。
     * @param deleteMarkerColumn 删除标记列的名称。
     * @param deleteMarkerValues 删除标记的活动值和删除值。
     * @return 返回修改后的SQL语句。
     */
    private String updateSql(String sql, String deleteMarkerColumn, String[] deleteMarkerValues) {
        String activeValue = deleteMarkerValues[0];
        String deletedValue = deleteMarkerValues[1];

        String updatedSql = sql.replaceAll("(?i)DELETE FROM", "UPDATE")
                .replaceAll(deleteMarkerColumn + "\\s*=\\s*" + activeValue, deleteMarkerColumn + " = " + deletedValue);

        updatedSql = updatedSql.replaceFirst("(?i)WHERE", "SET " + deleteMarkerColumn + " = " + deletedValue + " WHERE");

        return updatedSql;
    }

    /**
     * 根据原始MappedStatement和修改后的SQL创建新的MappedStatement。
     *
     * @param ms 原始MappedStatement对象。
     * @param sql 修改后的SQL语句。
     * @return 返回新的MappedStatement对象。
     */
    private MappedStatement copyFromMappedStatement(MappedStatement ms, String sql) {
        BoundSql boundSql = ms.getBoundSql(null);
        BoundSql newBoundSql = new BoundSql(ms.getConfiguration(), sql, boundSql.getParameterMappings(), boundSql.getParameterObject());
        for (ParameterMapping mapping : boundSql.getParameterMappings()) {
            String property = mapping.getProperty();
            if (boundSql.hasAdditionalParameter(property)) {
                newBoundSql.setAdditionalParameter(property, boundSql.getAdditionalParameter(property));
            }
        }
        return new MappedStatement.Builder(ms.getConfiguration(), ms.getId(), new BoundSqlSqlSource(newBoundSql), ms.getSqlCommandType())
                .resource(ms.getResource())
                .fetchSize(ms.getFetchSize())
                .statementType(ms.getStatementType())
                .keyGenerator(ms.getKeyGenerator())
                .databaseId(ms.getDatabaseId())
                .lang(ms.getLang())
                .timeout(ms.getTimeout())
                .parameterMap(ms.getParameterMap())
                .resultMaps(ms.getResultMaps())
                .cache(ms.getCache())
                .flushCacheRequired(ms.isFlushCacheRequired())
                .useCache(ms.isUseCache())
                .build();
    }

    /**
     * 插件包装方法。
     *
     * @param target 目标对象。
     * @return 返回包装后的对象。
     */
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    /**
     * 设置拦截器属性。
     *
     * @param properties 拦截器属性。
     */
    @Override
    public void setProperties(Properties properties) {
        // 在这里配置拦截器的属性
    }

    /**
     * BoundSqlSqlSource类，实现SqlSource接口，用于提供BoundSql对象作为SQL源。
     */
    private static class BoundSqlSqlSource implements SqlSource {
        private final BoundSql boundSql;

        public BoundSqlSqlSource(BoundSql boundSql) {
            this.boundSql = boundSql;
        }

        /**
         * 获取BoundSql对象。
         *
         * @param parameterObject 参数对象。
         * @return 返回BoundSql对象。
         */
        @Override
        public BoundSql getBoundSql(Object parameterObject) {
            return boundSql;
        }
    }
}
