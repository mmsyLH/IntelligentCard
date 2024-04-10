package asia.lhweb.IntelligentCard.service.impl;

import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.mapper.CyPatientMapper;
import asia.lhweb.IntelligentCard.model.pojo.CyPatient;
import asia.lhweb.IntelligentCard.service.CyPatientService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author :罗汉
 * @date : 2024/4/10
 */
@Service
public class CyPatientServiceImpl implements CyPatientService {
    @Resource
    private CyPatientMapper cyPatientMapper;
    /**
     * 按病人选择
     *
     * @param cyPatient cy病人
     * @return {@link Result}
     */
    @Override
    public Result selectByPatient(CyPatient cyPatient) {
        if (cyPatientMapper.selectByPatientOr(cyPatient)==null){
            return Result.error("未找到该病人");
        }
        return Result.success(cyPatientMapper.selectByPatientOr(cyPatient),"查询病人成功");
    }
}
