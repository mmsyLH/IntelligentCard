package asia.lhweb.IntelligentCard.mapper;

import asia.lhweb.IntelligentCard.model.vo.CyMenuVO;

import java.util.List;

/**
* @author Administrator
* @description 针对表【cy_menu】的数据库操作Mapper
* @createDate 2024-04-10 10:02:11
* @Entity asia.lhweb.IntelligentCard.model.pojo.CyMenu
*/
public interface CyMenuMapper {

    List<CyMenuVO> selectMenuTreeByAdminId(Integer adminId);
}




