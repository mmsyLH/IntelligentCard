package asia.lhweb.IntelligentCard.service;


import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.model.dto.CyCardDTO;

/**
* @author Administrator
* @description 针对表【Cy_card】的数据库操作Service
* @createDate 2024-04-03 12:56:32
*/
public interface CyCardService {
    /**
     * 按卡号选择
     *
     * @param cyCardDTO 赛门铁克
     * @return {@link Result}
     */
    Result selectByCyCardDTO(CyCardDTO cyCardDTO);

    /**
     * 添加卡
     *
     * @return {@link Result}
     */
    Result addCards(String prefix, int startNo, int count);
}
