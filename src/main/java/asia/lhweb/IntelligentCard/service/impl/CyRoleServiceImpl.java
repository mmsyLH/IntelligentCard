package asia.lhweb.IntelligentCard.service.impl;


import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.mapper.CyRoleMapper;
import asia.lhweb.IntelligentCard.model.PageResult;
import asia.lhweb.IntelligentCard.model.pojo.CyRole;
import asia.lhweb.IntelligentCard.service.CyRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public Result<PageResult<CyRole>> getAllRole(int pageNo, int pageSize) {
        //开启分页插件
        PageHelper.startPage(pageNo, pageSize);
        List<CyRole> allRole = cyRoleMapper.getAllRole();
        PageInfo<CyRole> pageInfo = new PageInfo<>();
        PageResult<CyRole> pageResult = new PageResult<>();
        pageResult.setItems(pageInfo.getList());
        pageResult.setPageNo(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalRow((int) pageInfo.getTotal());
        pageResult.setPageTotalCount(pageInfo.getPages());
        return Result.success(pageResult,"查询所有角色成功");
    }
}
