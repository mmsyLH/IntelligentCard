package asia.lhweb.IntelligentCard.controller.admin;

import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.model.dto.LoginAdminDTO;
import asia.lhweb.IntelligentCard.model.pojo.CyAdmin;
import asia.lhweb.IntelligentCard.service.CyAdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;


/**
 * @author :罗汉
 * @date : 2024/4/2
 */
@RestController
@RequestMapping("/admin/admin")
public class AdminController {
    @Resource
    private CyAdminService cyAdminService;

    @PostMapping(value = "/login")
    @ResponseBody
    public Result login(@RequestBody LoginAdminDTO loginAdminDTO, HttpServletRequest request) throws UnsupportedEncodingException {
        // 获取验证码
        // System.out.println("登录的code:"+code);
        if (loginAdminDTO == null){
            return Result.error("登录失败");
        }
        if (loginAdminDTO.getAccount() == null || loginAdminDTO.getPassword() == null){
            return Result.error("账号或密码不能为空");
        }

        if (loginAdminDTO.getCode().equals("")|| loginAdminDTO.getCode() == null){
            return Result.error("验证码不能为空");
        }
        String codeStr = (String) request.getSession().getAttribute("captcha");
        if (codeStr == null || !codeStr.equals(loginAdminDTO.getCode())) {
            return Result.error("验证码错误");
        }
        // return cyAdminService.login(account,password);
        return cyAdminService.login(loginAdminDTO.getAccount(), loginAdminDTO.getPassword(),request);
    }

    /**
     * 按id删除
     *
     * @param ids id
     * @return {@link Result}
     */
    @RequestMapping(value = "/deletes")
    public Result deletesById(@RequestBody List<Integer> ids) {
        return cyAdminService.deletesById(ids);
    }

    /**
     * 获取管理员列表
     *
     * @return {@link Result}
     */
    @RequestMapping(value = "/list")
    public Result list() {
        return cyAdminService.list();
    }

    // 修改
    @RequestMapping(value = "/update")
    public Result update(@RequestBody CyAdmin cyAdmin) {
        return cyAdminService.update(cyAdmin);
    }

    @GetMapping("/page")
    public Result page(CyAdmin cyAdmin, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize) {
        return cyAdminService.page(cyAdmin, pageNo, pageSize);
    }
}
