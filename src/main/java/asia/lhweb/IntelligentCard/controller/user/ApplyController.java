package asia.lhweb.IntelligentCard.controller.user;

import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.model.pojo.CyCardApply;
import asia.lhweb.IntelligentCard.service.CyApplyService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author :罗汉
 * @date : 2024/4/2
 */
@RestController("userApplyController")
@RequestMapping("/user/cardApply")
public class ApplyController {
    //注入
    @Resource
    private CyApplyService cyApplyService;

    //申请卡
    @RequestMapping(value = "/add")
    public Result cardApply(@RequestBody CyCardApply cyCardApply) {
        return cyApplyService.add(cyCardApply);
    }
}
