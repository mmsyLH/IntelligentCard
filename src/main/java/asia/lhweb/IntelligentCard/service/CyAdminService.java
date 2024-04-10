package asia.lhweb.IntelligentCard.service;


import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.model.dto.CyAdminDTO;
import asia.lhweb.IntelligentCard.model.vo.CyAdminVO;

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
     * @return {@link Result}<{@link CyAdminVO}>
     */
    Result<CyAdminVO> login(String account, String password);

}
