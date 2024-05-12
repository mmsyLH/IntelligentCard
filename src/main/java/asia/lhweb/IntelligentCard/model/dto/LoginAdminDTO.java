package asia.lhweb.IntelligentCard.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 管理员信息表
 * @TableName cy_admin
 */
@Data
public class LoginAdminDTO implements Serializable {

    private String account;

    private String code;

    private String password;

}