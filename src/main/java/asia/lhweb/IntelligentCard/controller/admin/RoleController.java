package asia.lhweb.IntelligentCard.controller.admin;

import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.model.PageResult;
import asia.lhweb.IntelligentCard.model.pojo.CyRole;
import asia.lhweb.IntelligentCard.service.CyRoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author :罗汉
 * @date : 2024/4/26
 */
@RestController
@RequestMapping("/admin/role")
public class RoleController {
    @Resource
    private CyRoleService cyRoleService;
    // @RequestMapping(value = "/selectByAdminRoleId")
    // public Result<CyRole> selectByAdminRoleId(Integer adminRoleId) {
    //     return cyRoleService.selectByAdminRoleId(adminRoleId);
    // }
    @GetMapping(value = "/page")
    public Result<PageResult<CyRole>> getAllRole(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize")int pageSize) {
        return cyRoleService.getAllRole(pageNo,pageSize);
    }
}
