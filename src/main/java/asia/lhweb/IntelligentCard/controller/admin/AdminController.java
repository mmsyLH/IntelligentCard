package asia.lhweb.IntelligentCard.controller.admin;

import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.model.LoginAdminDTO;
import asia.lhweb.IntelligentCard.model.pojo.CyAdmin;
import asia.lhweb.IntelligentCard.model.vo.CyAdminVO;
import asia.lhweb.IntelligentCard.service.CyAdminService;
import asia.lhweb.IntelligentCard.service.SysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;


/**
 * @author :罗汉
 * @date : 2024/4/2
 */
@CrossOrigin
@RestController
@RequestMapping("/admin/admin")
public class AdminController {
    @Resource
    private SysUserService userService;
    @Resource
    private CyAdminService cyAdminService;

    @PostMapping(value = "/login")
    @ResponseBody
    public Result<CyAdminVO> login(@RequestBody LoginAdminDTO loginAdminDTO, HttpServletRequest request) throws UnsupportedEncodingException {
        // 获取验证码
        // System.out.println("登录的code:"+code);
        System.out.println("登录的loginAdminDTO:" + loginAdminDTO);
        HttpSession session = request.getSession();
        System.out.println("登录的sessionId:" + session.getId());
        Object captcha = request.getSession().getAttribute("captcha");
        String codeInSession = (String) request.getSession().getAttribute("captcha");
        session.setAttribute("test", "123");
        // if (codeInSession == null || !codeInSession.equalsIgnoreCase(code)) {
        //     return Result.error("验证码错误");
        // }
        // return cyAdminService.login(account,password);
        return cyAdminService.login(loginAdminDTO.getAccount(), loginAdminDTO.getPassword());
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

    @GetMapping("page")
    public Result page(CyAdmin cyAdmin, Integer pageNo, Integer pageSize) {
        return cyAdminService.page(cyAdmin, pageNo, pageSize);
    }
}
