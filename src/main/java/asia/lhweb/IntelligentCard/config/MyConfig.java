package asia.lhweb.IntelligentCard.config;

import asia.lhweb.IntelligentCard.utils.XMLParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author :罗汉
 * @date : 2024/4/2
 */
@Configuration
public class MyConfig {
    @Bean
    public XMLParser getXMLParser(){
        return new XMLParser();
    }


}
