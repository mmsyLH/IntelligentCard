package asia.lhweb.IntelligentCard.mapper;

import asia.lhweb.IntelligentCard.annotation.Entity;
import asia.lhweb.IntelligentCard.model.pojo.CyAdmin;
import asia.lhweb.IntelligentCard.model.vo.CyAdminVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author Administrator
* @description 针对表【cy_admin(管理员信息表)】的数据库操作Mapper
* @createDate 2024-04-10 10:02:11
* @Entity asia.lhweb.IntelligentCard.model.pojo.CyAdmin
*/
@Entity(CyAdmin.class)
public interface CyAdminMapper {


    /**
     * 登录
     *
     * @param account  账户
     * @param password 密码
     * @return {@link CyAdminVO}
     */
    CyAdminVO login(@Param("adminAccount") String account,@Param("adminPwd") String password);
    /**
     * 根据部门id查询
     *
     * @param departmentId 部门id
     * @return {@link CyAdminVO}
     */
    CyAdminVO selectByDepartmentId(Integer departmentId);

    @Select("select * from cy_admin")
    List<CyAdmin> list();

    int update(CyAdmin cyAdmin);

    Page<CyAdmin> selectAllIf(CyAdmin cyAdmin);

    int deletesById(List<Integer> ids);
    int deleteOneById(int id);
}




