package asia.lhweb.IntelligentCard.model.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * 权限菜单表
 * @TableName cy_permission
 */
@Data
public class CyPermission implements Serializable {
    /**
     * 
     */
    private Integer permissionId;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 菜单id
     */
    private Integer menuId;

    private static final long serialVersionUID = 1L;
}