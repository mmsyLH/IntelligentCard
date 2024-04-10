package asia.lhweb.IntelligentCard.service;


import asia.lhweb.IntelligentCard.common.Result;

/**
* @author Administrator
* @description 针对表【Cy_card】的数据库操作Service
* @createDate 2024-04-03 12:56:32
*/
public interface CyRoleService {
    Result selectByAdminRoleId(Integer adminRoleId);
}
