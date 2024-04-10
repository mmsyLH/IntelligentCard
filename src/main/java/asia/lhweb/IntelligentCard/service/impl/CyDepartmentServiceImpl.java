package asia.lhweb.IntelligentCard.service.impl;

import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.mapper.CyDepartmentMapper;
import asia.lhweb.IntelligentCard.model.vo.CyDepartmentVO;
import asia.lhweb.IntelligentCard.service.CyDepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :罗汉
 * @date : 2024/4/10
 */
@Service
public class CyDepartmentServiceImpl implements CyDepartmentService {
    @Resource
    private CyDepartmentMapper cyDepartmentMapper;
    @Override
    public Result<List<CyDepartmentVO>> selectByDepartmentId(Integer departmentId) {
        List<CyDepartmentVO> cyDepartmentVOList=cyDepartmentMapper.selectByDepartmentId(departmentId);
        if (cyDepartmentVOList.size()==0){
            return Result.error("查询失败");
        }
        return Result.success(cyDepartmentVOList,"查询成功");
    }
}
