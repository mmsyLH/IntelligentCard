package asia.lhweb.IntelligentCard.service.impl;

import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.mapper.CyDepartmentMapper;
import asia.lhweb.IntelligentCard.model.pojo.CyDepartment;
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
    public Result<CyDepartmentVO> selectByDepartmentId(Integer departmentId) {
        CyDepartmentVO cyDepartmentVOList = cyDepartmentMapper.selectByDepartmentId(departmentId);
        if (cyDepartmentVOList == null) {
            return Result.error("查询失败");
        }
        return Result.success(cyDepartmentVOList, "查询成功");
    }

    @Override
    public Result list() {
        List<CyDepartment> cyDepartmentList = cyDepartmentMapper.list();
        if (cyDepartmentList == null) {
            return Result.error("查询失败");
        }
        if (cyDepartmentList.size() == 0) {
            return Result.error("暂无数据");
        }
        return Result.success(cyDepartmentList, "查询成功");
    }

    @Override
    public Result update(CyDepartment cyDepartment) {
        int i = cyDepartmentMapper.update(cyDepartment);
        if (i > 0) {
            return Result.success("修改成功");
        } else {
            return Result.error("修改失败");
        }
    }
}
