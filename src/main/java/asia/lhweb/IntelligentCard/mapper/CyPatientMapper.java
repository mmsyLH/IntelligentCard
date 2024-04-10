package asia.lhweb.IntelligentCard.mapper;

import asia.lhweb.IntelligentCard.model.pojo.CyPatient;

/**
* @author Administrator
* @description 针对表【cy_patient(就诊人信息)】的数据库操作Mapper
* @createDate 2024-04-10 10:02:11
* @Entity asia.lhweb.IntelligentCard.model.pojo.CyPatient
*/
public interface CyPatientMapper {

    CyPatient selectByPatientOr(CyPatient cyPatient);
}




