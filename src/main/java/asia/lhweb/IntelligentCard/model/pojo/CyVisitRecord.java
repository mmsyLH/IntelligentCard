package asia.lhweb.IntelligentCard.model.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 就诊记录表
 * @TableName cy_visit_record
 */
@Data
public class CyVisitRecord implements Serializable {
    /**
     * 
     */
    private Integer visitId;

    /**
     * 就诊人id
     */
    private Integer visitPatientId;

    /**
     * 医生id
     */
    private Integer visitAdminId;

    /**
     * 就诊小姐
     */
    private String visitSummary;

    /**
     * 药方
     */
    private String visitPrescript;

    /**
     * 就诊时间
     */
    private Date visitCreateTime;

    /**
     * 就诊更新时间
     */
    private Date visitUpdateTime;

    private static final long serialVersionUID = 1L;
}