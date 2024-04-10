package asia.lhweb.IntelligentCard.model.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 就诊人信息
 * @TableName cy_patient
 */
@Data
public class CyPatient implements Serializable {
    /**
     * 
     */
    private Integer patientId;

    /**
     * 就诊人账号
     */
    private String patientAccount;

    /**
     * 就诊人密码
     */
    private String patientPwd;

    /**
     * 就诊人姓名
     */
    private String patientName;

    /**
     * 就诊人联系地址
     */
    private String patientAddress;

    /**
     * 就诊人是否被删除1删除0未删除
     */
    private Integer patientIsDelete;

    /**
     * 就诊人创建时间
     */
    private Date patientCreateTime;

    /**
     * 就诊人信息更新时间
     */
    private Date patientUpdateTime;

    /**
     * 就诊人手机号
     */
    private String patientPhone;

    private static final long serialVersionUID = 1L;
}