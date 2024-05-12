package asia.lhweb.IntelligentCard.service;


import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.model.dto.CyAdminDTO;
import asia.lhweb.IntelligentCard.model.pojo.CyAdmin;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author Administrator
* @description 针对表【Cy_Admin】的数据库操作Service
* @createDate 2024-04-03 12:56:32
*/
public interface CyAdminService {
    Result selectByCyAdminDTO(CyAdminDTO cyAdminDTO);

    /**
     * 登录
     *
     * @param account  账户
     * @param password 密码
     * @param request
     * @return {@link Result}<{@l.0ink CyAdminVO}>
     */
    Result login(String account, String password, HttpServletRequest request);

    Result list();

    Result update(CyAdmin cyAdmin);

    /**
     * 页面
     *
     * @param cyAdmin  cy管理
     * @param page     页面
     * @param pageSize 页面大小
     * @return {@link Result}
     */
    Result page(CyAdmin cyAdmin, Integer page, Integer pageSize);

    Result deletesById(List<Integer> ids);
}
