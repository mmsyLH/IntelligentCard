package asia.lhweb.IntelligentCard.service.impl;

import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.mapper.CyAdminMapper;
import asia.lhweb.IntelligentCard.service.CyMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author :罗汉
 * @date : 2024/4/10
 */
@Service
public class CyMenuServiceImpl implements CyMenuService {

    @Resource
    private CyAdminMapper cyAdminMapper;

    /**
     * 按管理员角色id选择菜单
     *
     * @param adminRoleId 管理员角色id
     * @return {@link Result}
     */
    @Override
    public Result selectMenuByAdminRoleId(Integer adminRoleId) {
        cyAdminMapper.selectByDepartmentId(adminRoleId);
        return null;
    }
}
