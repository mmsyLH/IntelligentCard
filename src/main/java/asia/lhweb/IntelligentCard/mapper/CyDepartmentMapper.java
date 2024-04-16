package asia.lhweb.IntelligentCard.mapper;

import asia.lhweb.IntelligentCard.model.pojo.CyDepartment;
import asia.lhweb.IntelligentCard.model.vo.CyDepartmentVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author Administrator
* @description 针对表【cy_department(科室表)】的数据库操作Mapper
* @createDate 2024-04-10 10:02:11
* @Entity asia.lhweb.IntelligentCard.model.pojo.CyDepartment
*/
public interface CyDepartmentMapper {

    /**
     * 按部门编号选择
     *
     * @param departmentId 部门id
     * @return {@link List}<{@link CyDepartmentVO}>
     */
    CyDepartmentVO selectByDepartmentId(Integer departmentId);
    @Select("select * from cy_department")
    List<CyDepartment> list();

    int update(CyDepartment cyDepartment);
}




