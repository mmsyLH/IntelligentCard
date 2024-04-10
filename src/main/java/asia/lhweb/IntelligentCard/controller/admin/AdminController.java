package asia.lhweb.IntelligentCard.controller.admin;

import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.model.vo.CyAdminVO;
import asia.lhweb.IntelligentCard.service.CyAdminService;
import asia.lhweb.IntelligentCard.service.SysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author :罗汉
 * @date : 2024/4/2
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private SysUserService userService;
    @Resource
    private CyAdminService cyAdminService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Result<CyAdminVO> login(@RequestParam("account") String account, @RequestParam("password")  String password) {
        return cyAdminService.login(account,password);
    }

    /**
     * 按id删除
     *
     * @param ids id
     * @return {@link Result}
     */
    @RequestMapping(value = "/deletes")
    public Result deletesById(@RequestBody List<Integer> ids) {
        return userService.deletesById(ids);
    }

}
