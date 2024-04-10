package asia.lhweb.IntelligentCard.controller.user;

import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.service.CyRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author :罗汉
 * @date : 2024/4/2
 */
@RestController("userRoleController")
@RequestMapping("/user")
public class RoleController {
    //注入
    @Resource
    private CyRoleService cyRoleService;

    /**
     * 根据管理员角色id选择
     *
     * @param adminRoleId 管理员角色id
     * @return {@link Result}
     */
    @RequestMapping(value = "/selectByAdminRoleId")
    public Result selectByAdminRoleId(Integer adminRoleId) {
        return cyRoleService.selectByAdminRoleId(adminRoleId);
    }
}
