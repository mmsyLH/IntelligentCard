package asia.lhweb.IntelligentCard.controller.admin;

import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.model.vo.CyDepartmentVO;
import asia.lhweb.IntelligentCard.service.CyDepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * 部门控制器
 *
 * @author 罗汉
 * @date 2024/04/10
 */
@RestController("adminDepartmentController")
@RequestMapping("/admin/department")
public class DepartmentController {
    // 注入
    @Resource
    private CyDepartmentService cyDepartmentService;

    /**
     * 按部门编号选择
     *
     * @param departmentId 部门id
     * @return {@link Result}<{@link List}<{@link CyDepartmentVO}>>
     */
    @GetMapping("/selectByDepartmentId")
        public Result<List<CyDepartmentVO>> selectByDepartmentId(Integer departmentId) {
        return cyDepartmentService.selectByDepartmentId(departmentId);
    }
}
