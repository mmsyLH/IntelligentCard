package asia.lhweb.IntelligentCard.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 科室表
 * @TableName cy_department
 */
@Data
public class CyDepartmentVO implements Serializable {
    /**
     * 
     */
    private Integer departmentId;

    /**
     * 科室名称
     */
    private String departmentName;

    /**
     * 所属上级科室
     */
    private Integer departmentParentId;

    /**
     * 科室是否启用1是0否
     */
    private Integer departmentStatus;

    /**
     * 科室是否显示1显示0不显示
     */
    private Integer departmentIsShow;

    /**
     * 科室是否删除1是0否
     */
    private Integer departmentIsDelete;

    /**
     * 科室创建时间
     */
    private Date departmentCreateTime;

    /**
     * 科室更新时间
     */
    private Date departmentUpdateTime;

    private List<CyAdminVO> cyAdminVOList;

    private static final long serialVersionUID = 1L;
}