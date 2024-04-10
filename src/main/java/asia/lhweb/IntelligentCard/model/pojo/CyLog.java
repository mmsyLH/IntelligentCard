package asia.lhweb.IntelligentCard.model.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 后台操作日志表
 * @TableName cy_log
 */
@Data
public class CyLog implements Serializable {
    /**
     * 
     */
    private Integer logId;

    /**
     * 后台管理员账号
     */
    private String logAccount;

    /**
     * 后台管理员操作
     */
    private String logInfo;

    /**
     * 操作时间
     */
    private Date logCreateTime;

    private static final long serialVersionUID = 1L;
}