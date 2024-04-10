package asia.lhweb.IntelligentCard.controller.user;

import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.model.pojo.CyPatient;
import asia.lhweb.IntelligentCard.service.CyPatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author :罗汉
 * @date : 2024/4/2
 */
@RestController("userPatientController")
@RequestMapping("/user")
public class PatientController {
    @Resource
    private CyPatientService cyPatientService;

    /**
     * 根据患者信息查询相关数据。
     *
     * @param cyPatient 包含患者信息的对象，用于查询条件。
     * @return 返回查询结果，封装在Result对象中。
     */
    @GetMapping("/selectByPatient")
    public Result selectByPatient(CyPatient cyPatient){
        return cyPatientService.selectByPatient(cyPatient);
    }

}
