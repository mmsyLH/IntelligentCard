package asia.lhweb.IntelligentCard.model.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 卡申请/审批记录表
 * @TableName cy_card_apply
 */
@Data
public class CyCardApply implements Serializable {
    /**
     * 
     */
    private Integer applyId;

    /**
     * 申请人id
     */
    private Integer applyAdminId;

    /**
     * 审批人id
     */
    private Integer applyApproveId;

    /**
     * 申请批次号
     */
    private String applyBatchNo;

    /**
     * 申请数量
     */
    private Integer applyNumber;

    /**
     * 申请时间
     */
    private Date applyCreateTime;

    /**
     * 审核时间
     */
    private Date applyApproveTime;

    /**
     * 审核状态0待审核1通过2拒绝
     */
    private String applyApproveStatus;

    /**
     * 审核结果说明
     */
    private String applyApproveInfo;

    private static final long serialVersionUID = 1L;
}