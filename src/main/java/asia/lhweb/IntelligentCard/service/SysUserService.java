package asia.lhweb.IntelligentCard.service;


import asia.lhweb.IntelligentCard.common.Result;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_user(系统用户表)】的数据库操作Service
* @createDate 2024-04-03 12:56:32
*/
public interface SysUserService {

    /**
     * 登录
     *
     * @param account  账户
     * @param password 密码
     * @return {@link Result}
     */
    Result login(String account, String password);

    /**
     * 按id删除
     *
     * @param ids id
     * @return {@link Result}
     */
    Result deletesById(List<Integer> ids);
}
