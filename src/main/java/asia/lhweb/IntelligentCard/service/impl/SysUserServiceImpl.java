// package asia.lhweb.IntelligentCard.service.impl;
//
// import asia.lhweb.IntelligentCard.common.Result;
// import asia.lhweb.IntelligentCard.mapper.UserMapper;
// import asia.lhweb.IntelligentCard.service.SysUserService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
//
// import java.util.List;
//
// /**
//  * @author :罗汉
//  * @date : 2024/4/3
//  */
// @Service
// public class SysUserServiceImpl implements SysUserService {
//     @Autowired
//     private UserMapper userMapper;
//     /**
//      * 登录
//      *
//      * @param account  账户
//      * @param password 密码
//      * @return {@link Result}
//      */
//     @Override
//     public Result login(String account, String password) {
//         //todo dao层
//         SysUser login = userMapper.login(account, password);
//         if (login==null){
//             return Result.error("账号或密码错误");
//         }
//         return Result.success(login,"登录ok");
//         // if ("admin".equals(account)&&"123456".equals(password)){
//         //
//         //     return Result.success("登录成功");
//         // }else {
//         //     return Result.error("账号或密码错误");
//         // }
//     }
//
//     /**
//      * 按id删除
//      *
//      * @param ids id
//      * @return {@link Result}
//      */
//     @Override
//     public Result deletesById(List<Integer> ids) {
//         int i =userMapper.deletesById(ids);
//         if (i>0){
//             return Result.success("删除成功");
//         }
//         return Result.error("删除失败");
//     }
// }
