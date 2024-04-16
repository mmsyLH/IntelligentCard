package asia.lhweb.IntelligentCard.service.impl;


import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.mapper.CyAdminMapper;
import asia.lhweb.IntelligentCard.model.PageResult;
import asia.lhweb.IntelligentCard.model.dto.CyAdminDTO;
import asia.lhweb.IntelligentCard.model.pojo.CyAdmin;
import asia.lhweb.IntelligentCard.model.vo.CyAdminVO;
import asia.lhweb.IntelligentCard.service.CyAdminService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 * @description 针对表【Cy_Admin】的数据库操作Service
 * @createDate 2024-04-03 12:56:32
 */
@Service
public class CyAdminServiceImpl implements CyAdminService {
    @Resource
    private CyAdminMapper cyAdminMapper;

    public Result selectByCyAdminDTO(CyAdminDTO cyAdminDTO) {

        return null;
    }

    /**
     * 登录
     *
     * @param account  账户
     * @param password 密码
     * @return {@link Result}<{@link CyAdminVO}>
     */
    @Override
    public Result<CyAdminVO> login(String account, String password) {
        // 根据用户名判断 用户是否存在 不存存在就返回提示信息
        CyAdminVO cyAdminVO = cyAdminMapper.login(account, password);
        if (cyAdminVO == null) {
            return Result.error("登录失败，账户或者密码错误");
        }
        return Result.success(cyAdminVO, "登录成功");
    }

    /**
     * 获取管理员列表
     *
     * @return {@link Result}
     */
    @Override
    public Result list() {
        // 查询所有管理员
        List<CyAdmin> cyAdminList = cyAdminMapper.list();
        if (cyAdminList.size() == 0) {
            return Result.error("管理员列表为空");
        }
        return Result.success(cyAdminList, "管理员列表获取成功");
    }

    /**
     * 更新
     *
     * @param cyAdmin cy管理
     * @return {@link Result}
     */
    @Override
    public Result update(CyAdmin cyAdmin) {
        int i = cyAdminMapper.update(cyAdmin);
        if (i == 1) {
            return Result.success("更新成功");
        } else {
            return Result.error("更新失败");
        }

    }

    /**
     * 分页
     *
     * @param cyAdmin  cy管理
     * @param pageSize 页面大小
     * @param pageNo   页面没有
     * @return {@link Result}
     */
    @Override
    public Result page(CyAdmin cyAdmin, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        // 紧跟着的第一个select方法会被分页
        Page<CyAdmin> adminPage = cyAdminMapper.selectAllIf(cyAdmin);
        PageResult<CyAdmin> pageResult = new PageResult<>();
        pageResult.setPageNo(pageNo);
        pageResult.setPageSize(pageSize);
        pageResult.setTotalRow((int) adminPage.getTotal());
        pageResult.setItems(adminPage.getResult());
        pageResult.setPageTotalCount(adminPage.getPages());
        if (adminPage.getResult().size() == 0) {
            return Result.error("管理员列表为空");
        }
        return Result.success(pageResult, "查询分页成功");
    }
}
