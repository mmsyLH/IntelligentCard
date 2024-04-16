package asia.lhweb.IntelligentCard.mapper;

import asia.lhweb.IntelligentCard.model.dto.CyAdminDTO;
import asia.lhweb.IntelligentCard.model.pojo.CyCard;
import asia.lhweb.IntelligentCard.model.pojo.CyCardApply;

import java.util.List;

/**
* @author Administrator
* @description 针对表【cy_card_apply(卡申请/审批记录表)】的数据库操作Mapper
* @createDate 2024-04-10 10:02:11
* @Entity asia.lhweb.IntelligentCard.model.pojo.CyCardApply
*/
public interface CyCardApplyMapper {
    List<CyCard> selectByCyAdminDTO(CyAdminDTO cyAdminDTO);

    int add(CyCardApply cyCardApply);
}




