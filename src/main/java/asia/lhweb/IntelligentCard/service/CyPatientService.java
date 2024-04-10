package asia.lhweb.IntelligentCard.service;

import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.model.pojo.CyPatient;

/**
 * 就诊人服务
 *
 * @author 罗汉
 * @date 2024/04/10
 */
public interface CyPatientService {
    /**
     * 按病人选择
     *
     * @param cyPatient cy病人
     * @return {@link Result}
     */
    Result selectByPatient(CyPatient cyPatient);
}
