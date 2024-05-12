package asia.lhweb.IntelligentCard.service;


import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.model.PageResult;
import asia.lhweb.IntelligentCard.model.pojo.CyRole;

/**
* @author Administrator
* @description 针对表【Cy_card】的数据库操作Service
* @createDate 2024-04-03 12:56:32
*/
public interface CyRoleService {
    Result selectByAdminRoleId(Integer adminRoleId);

    Result<PageResult<CyRole>> getAllRole(int pageNo, int pageSize);
}
