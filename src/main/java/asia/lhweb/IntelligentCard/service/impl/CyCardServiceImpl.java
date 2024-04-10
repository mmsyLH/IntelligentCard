package asia.lhweb.IntelligentCard.service.impl;


import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.mapper.CyCardMapper;
import asia.lhweb.IntelligentCard.model.dto.CyCardDTO;
import asia.lhweb.IntelligentCard.model.pojo.CyCard;
import asia.lhweb.IntelligentCard.service.CyCardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 * @description 针对表【Cy_card】的数据库操作Service
 * @createDate 2024-04-03 12:56:32
 */
@Service
public class CyCardServiceImpl implements CyCardService {

    @Resource
    private CyCardMapper cyCardMapper;

    /**
     * 按卡号选择
     *
     * @param cyCardDTO 赛门铁克
     * @return {@link Result}
     */
    @Override
    public Result selectByCyCardDTO(CyCardDTO cyCardDTO) {
        List<CyCard> cyCards = cyCardMapper.selectByCyCardDTO(cyCardDTO);

        if (cyCards == null) {
            return Result.error("卡号不存在");
        }
        // if (cyCard.getCardIsDelete() == 1) {
        //     return Result.error("卡号已注销");
        // }
        // if (cyCard.getCardStatus() == 0) {
        //     return Result.error("卡号已挂失");
        // }

        return Result.success(cyCards, "请求成功");
    }
}
