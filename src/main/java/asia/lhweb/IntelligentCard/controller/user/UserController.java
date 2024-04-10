// package asia.lhweb.IntelligentCard.controller.user;
//
// import asia.lhweb.IntelligentCard.common.Result;
// import asia.lhweb.IntelligentCard.service.SysUserService;
// import org.springframework.web.bind.annotation.*;
//
// import javax.annotation.Resource;
// import java.util.List;
//
//
// /**
//  * @author :罗汉
//  * @date : 2024/4/2
//  */
// @RestController("userController")
// @RequestMapping("/admin")
// public class UserController {
//     @Resource
//     private SysUserService userService;
//
//     @RequestMapping(value = "/login",method = RequestMethod.GET)
//     @ResponseBody
//     public Result login(@RequestParam("account") String account,@RequestParam("password")  String password) {
//         Result res = userService.login(account,password);
//         return res;
//     }
//
//     /**
//      * 按id删除
//      *
//      * @param ids id
//      * @return {@link Result}
//      */
//     @RequestMapping(value = "/deletes")
//     public Result deletesById(@RequestBody List<Integer> ids) {
//         return userService.deletesById(ids);
//     }
// }
