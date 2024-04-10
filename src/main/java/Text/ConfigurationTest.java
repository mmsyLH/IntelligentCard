package Text;

import asia.lhweb.IntelligentCard.config.MyConfig;
import asia.lhweb.IntelligentCard.utils.XMLParser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author :罗汉
 * @date : 2024/4/2
 */
public class ConfigurationTest {
    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        XMLParser getXMLParser = (XMLParser) ioc.getBean("getXMLParser");
        System.out.println(getXMLParser);
    }
}
