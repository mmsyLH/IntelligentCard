package asia.lhweb.IntelligentCard.service;

import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.model.pojo.CyDepartment;
import asia.lhweb.IntelligentCard.model.vo.CyDepartmentVO;

/**
 * Cy部门服务
 *
 * @author 罗汉
 * @date 2024/04/10
 */
public interface CyDepartmentService {

    /**
     * 按部门编号查询
     *
     * @param departmentId 部门id
     * @return {@link Result}<{@link CyDepartmentVO}>
     */
    Result<CyDepartmentVO> selectByDepartmentId(Integer departmentId);

    Result list();

    Result update(CyDepartment cyDepartment);
}
