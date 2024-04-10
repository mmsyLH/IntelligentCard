package asia.lhweb.IntelligentCard.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * @TableName cy_menu
 */
@Data
public class CyMenuVO implements Serializable {
    /**
     * 
     */
    private Integer menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单组件
     */
    private String menuComponent;

    /**
     * 菜单路由
     */
    private String menuPath;

    /**
     * 菜单图标
     */
    private String menuIcon;

    /**
     * 菜单是否启用1启用0禁用
     */
    private Integer menuStatus;

    /**
     * 所属父级菜单id
     */
    private Integer menuParentId;

    /**
     * 菜单是否隐藏1隐藏0未隐藏
     */
    private Integer menuIsHidden;

    /**
     * 菜单排序-数字越大排在越上面
     */
    private Integer menuSort;

    /**
     * 菜单创建时间
     */
    private Date menuCreateTime;

    /**
     * 菜单更新时间
     */
    private Date menuUpdateTime;

    private List<CyMenuVO> cyMenuVOList;

    private static final long serialVersionUID = 1L;
}