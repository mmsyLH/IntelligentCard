package asia.lhweb.IntelligentCard.service.impl;


import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.mapper.CyCardMapper;
import asia.lhweb.IntelligentCard.model.dto.CyCardDTO;
import asia.lhweb.IntelligentCard.model.pojo.CyCard;
import asia.lhweb.IntelligentCard.service.CyCardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @description 针对表【Cy_card】的数据库操作Service
 * @createDate 2024-04-03 12:56:32
 */
@Service
public class CyCardServiceImpl implements CyCardService {

    @Resource
    private CyCardMapper cyCardMapper;

    /**
     * 按卡号选择
     *
     * @param cyCardDTO 赛门铁克
     * @return {@link Result}
     */
    @Override
    public Result selectByCyCardDTO(CyCardDTO cyCardDTO) {
        List<CyCard> cyCards = cyCardMapper.selectByCyCardDTO(cyCardDTO);

        if (cyCards == null) {
            return Result.error("卡号不存在");
        }
        // if (cyCard.getCardIsDelete() == 1) {
        //     return Result.error("卡号已注销");
        // }
        // if (cyCard.getCardStatus() == 0) {
        //     return Result.error("卡号已挂失");
        // }

        return Result.success(cyCards, "请求成功");
    }

    /**
     * 添加卡
     *
     * @param prefix
     * @param startNo
     * @param count
     * @return {@link Result}
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result addCards(String prefix, int startNo, int count) {
        ArrayList<String> errCardsList = new ArrayList<>(); // 存储已存在的卡号

        // 方式2 单个插入
        try {
            for (int i = startNo; i < startNo + count; i++) {
                String cardNum = prefix + String.format("%08d", i);
                //测试事务
                if (i==2){
                    System.out.println(1/0);
                }
                // 检查卡号是否已存在
                if (cyCardMapper.isCardExists(cardNum)) {
                    errCardsList.add(cardNum);
                } else {
                   int res=cyCardMapper.addCard(prefix, cardNum);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return Result.success(errCardsList,"插入成功");
    }

}
