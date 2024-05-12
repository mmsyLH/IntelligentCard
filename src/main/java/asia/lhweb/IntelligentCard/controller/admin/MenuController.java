package asia.lhweb.IntelligentCard.controller.admin;

import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.service.CyMenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author :罗汉
 * @date : 2024/4/2
 */
@RestController("adminMenuController")
@RequestMapping("/admin/menu")
public class MenuController {
    @Resource
    private CyMenuService cyMenuService;

    /**
     * 根据管理员角色id查询菜单权限
     *
     * @param adminId 管理员id
     * @return {@link Result}
     */
    @GetMapping(value = "/selectByAdminId")
    public Result selectMenuTreeByAdminId(Integer adminId) {
        return cyMenuService.selectMenuTreeByAdminId(adminId);
    }
}
