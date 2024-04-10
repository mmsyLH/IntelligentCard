// package Text;
//
// import asia.lhweb.IntelligentCard.mapper.UserMapper;
//
// import asia.lhweb.IntelligentCard.utils.MybatisUtils;
// import org.apache.ibatis.session.SqlSession;
// import org.junit.Test;
//
// import java.util.List;
//
// /**
//  * @author :罗汉
//  * @date : 2024/4/3
//  */
// public class MybatisTest {
//     public static void main(String[] args) {
//         SqlSession sqlSession = MybatisUtils.getSqlSession();
//         UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//         int count = mapper.getCount();
//         System.out.println(count);
//     }
//
//     @Test
//     public void test() {
//         SqlSession sqlSession = MybatisUtils.getSqlSession(true);
//         UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//         List<SysUser> allUser = mapper.getAllUser();
//         allUser.forEach(System.out::println);
//     }
// }
