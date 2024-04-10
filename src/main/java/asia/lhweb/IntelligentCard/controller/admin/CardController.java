package asia.lhweb.IntelligentCard.controller.admin;

import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.model.dto.CyCardDTO;
import asia.lhweb.IntelligentCard.service.CyCardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author :罗汉
 * @date : 2024/4/10
 */
@RestController
@RequestMapping("/admin")
public class CardController {
    @Resource
    private CyCardService cyCardService;

    @PostMapping(value = "/selectByCyCardDTO")
    public Result selectByCyCardDTO(@RequestBody CyCardDTO cyCardDTO) {
        return cyCardService.selectByCyCardDTO(cyCardDTO);
    }
}
