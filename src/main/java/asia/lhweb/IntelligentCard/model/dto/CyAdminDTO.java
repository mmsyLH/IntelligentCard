package asia.lhweb.IntelligentCard.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 管理员信息表
 * @TableName cy_admin
 */
@Data
public class CyAdminDTO implements Serializable {
    /**
     * 
     */
    private Integer adminId;

    /**
     * 管理员账号
     */
    private String adminAccount;

    /**
     * 管理员密码
     */
    private String adminPwd;

    /**
     * 管理员姓名
     */
    private String adminName;

    /**
     * 管理员头像
     */
    private String adminFace;

    /**
     * 管理员所属角色
     */
    private Integer adminRoleId;

    /**
     * 管理员是否启用1正常0禁用
     */
    private Integer adminStatus;

    /**
     * 管理员是否被删除1是0否
     */
    private Integer adminIsDelete;

    /**
     * 管理员创建时间
     */
    private String adminCreateTime;

    /**
     * 管理员更新时间
     */
    private String adminUpdateTime;

    /**
     * 管理员所属部门
     */
    private Integer adminDepartmentId;

    private static final long serialVersionUID = 1L;
}