package asia.lhweb.IntelligentCard.service;

import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.model.pojo.CyCardApply;
import org.springframework.stereotype.Service;

/**
 * @author :罗汉
 * @date : 2024/4/15
 */

public interface CyApplyService {
    Result add(CyCardApply cyCardApply);
}
