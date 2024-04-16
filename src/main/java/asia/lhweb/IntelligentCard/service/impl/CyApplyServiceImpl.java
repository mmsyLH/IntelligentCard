package asia.lhweb.IntelligentCard.service.impl;

import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.mapper.CyCardApplyMapper;
import asia.lhweb.IntelligentCard.model.pojo.CyCardApply;
import asia.lhweb.IntelligentCard.service.CyApplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author :罗汉
 * @date : 2024/4/15
 */
@Service
public class CyApplyServiceImpl implements CyApplyService {
    @Resource
    private CyCardApplyMapper cyCardApplyMapper;
    @Override
    public Result add(CyCardApply cyCardApply) {
        int i=cyCardApplyMapper.add(cyCardApply);
        if (i<=0){
            return Result.error("添加失败");

        }
        return Result.success("添加成功");
    }
}
