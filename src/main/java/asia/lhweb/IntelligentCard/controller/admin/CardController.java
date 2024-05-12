package asia.lhweb.IntelligentCard.controller.admin;

import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.model.dto.CyCardDTO;
import asia.lhweb.IntelligentCard.service.CyCardService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author :罗汉
 * @date : 2024/4/10
 */
@RestController
@RequestMapping("/admin/card")
public class CardController {
    @Resource
    private CyCardService cyCardService;

    @PostMapping(value = "/selectByCyCardDTO")
    public Result selectByCyCardDTO(@RequestBody CyCardDTO cyCardDTO) {
        return cyCardService.selectByCyCardDTO(cyCardDTO);
    }

    @PostMapping(value = "/addCards")
    public Result addCards(@Param("prefix") String prefix, @Param("startNo") int startNo, @Param("count") int count){
        return cyCardService.addCards(prefix,startNo,count);
    }

}
