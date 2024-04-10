package asia.lhweb.IntelligentCard.model.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色表
 * @TableName cy_role
 */
@Data
public class CyRole implements Serializable {
    /**
     * 
     */
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

    private static final long serialVersionUID = 1L;
}