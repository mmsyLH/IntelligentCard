package asia.lhweb.IntelligentCard.service.impl;


import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.mapper.CyAdminMapper;
import asia.lhweb.IntelligentCard.model.dto.CyAdminDTO;
import asia.lhweb.IntelligentCard.model.vo.CyAdminVO;
import asia.lhweb.IntelligentCard.service.CyAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author Administrator
* @description 针对表【Cy_Admin】的数据库操作Service
* @createDate 2024-04-03 12:56:32
*/
@Service
public class CyAdminServiceImpl implements CyAdminService {
    @Resource
    private CyAdminMapper cyAdminMapper;
    public Result selectByCyAdminDTO(CyAdminDTO cyAdminDTO){
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
        //根据用户名判断 用户是否存在 不存存在就返回提示信息
        CyAdminVO cyAdminVO = cyAdminMapper.login(account, password);
        if (cyAdminVO == null) {
            return Result.error("登录失败，账户或者密码错误");
        }
        return Result.success(cyAdminVO,"登录成功");
    }
}
