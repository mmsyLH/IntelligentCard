package asia.lhweb.IntelligentCard.mapper;

import asia.lhweb.IntelligentCard.model.pojo.CyRole;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【cy_role(角色表)】的数据库操作Mapper
 * @createDate 2024-04-10 10:02:11
 * @Entity asia.lhweb.IntelligentCard.model.pojo.CyRole
 */
public interface CyRoleMapper {
    //    根据管理员的admin_role_id去查询角色表
    CyRole selectByAdminRoleId(Integer adminRoleId);

    List<CyRole> getAllRole();
}




