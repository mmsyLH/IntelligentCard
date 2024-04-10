package asia.lhweb.IntelligentCard.service.impl;


import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.mapper.CyRoleMapper;
import asia.lhweb.IntelligentCard.model.pojo.CyRole;
import asia.lhweb.IntelligentCard.service.CyRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @description 针对表【Cy_card】的数据库操作Service
 * @createDate 2024-04-03 12:56:32
 */
@Service
public class CyRoleServiceImpl implements CyRoleService {
    @Resource
    private CyRoleMapper cyRoleMapper;
    public Result selectByAdminRoleId(Integer adminRoleId) {
        CyRole cyRole = cyRoleMapper.selectByAdminRoleId(adminRoleId);
        if (cyRole == null) {
            return Result.error("未查询到该角色");
        }
        return Result.success(cyRole,"查询角色成功");
    }
}
