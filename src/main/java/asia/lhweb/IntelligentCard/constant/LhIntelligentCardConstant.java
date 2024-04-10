package asia.lhweb.IntelligentCard.constant;

/**
 * 一卡通项目的常量
 *
 * @author 罗汉
 * @date 2024/03/11
 */
public interface LhIntelligentCardConstant {
    /**
     * 盐
     */
    String SALT = "lh";
    /**
     * 项目名称
     */
    String SERVER_NAME = "IntelligentCard";
    /**
     * 应用名称
     */
    String WEBAPP_NAME = "webapp";
    /**
     * 最大请求大小
     */
    int MAX_REQUEST_SIZE = 1024 * 1024*50; // 设置最大请求大小为50MB
}
