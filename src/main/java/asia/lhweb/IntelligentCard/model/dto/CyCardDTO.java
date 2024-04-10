package asia.lhweb.IntelligentCard.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @TableName cy_card
 */
@Data
public class CyCardDTO implements Serializable {
    /**
     * 
     */
    private Integer cardId;

    /**
     * 卡前缀
     */
    private String cardPrefix;

    /**
     * 卡号
     */
    private String cardNumber;

    /**
     * 卡余额
     */
    private BigDecimal cardMoney;

    /**
     * 卡片是否被删除1是0否
     */
    private Integer cardIsDelete;

    /**
     * 卡状态0待领用1待使用2已使用
     */
    private Integer cardStatus;

    /**
     * 卡生成时间
     */
    private Date cardCreateTime;

    /**
     * 卡信息更新时间
     */
    private Date cardUpdateTime;

    /**
     * 卡病人身份证
     */
    private String cardPatientId;

    private static final long serialVersionUID = 1L;
}