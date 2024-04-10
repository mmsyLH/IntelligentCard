package asia.lhweb.IntelligentCard.model.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 售卡订单表
 * @TableName cy_card_order
 */
@Data
public class CyCardOrder implements Serializable {
    /**
     * 
     */
    private Integer orderId;

    /**
     * 卡号id
     */
    private Integer orderCardId;

    /**
     * 售卡人员id
     */
    private Integer orderSaleId;

    /**
     * 就诊人员id
     */
    private Integer orderPatientId;

    /**
     * 售卡时间
     */
    private Date orderCreateTime;

    private static final long serialVersionUID = 1L;
}