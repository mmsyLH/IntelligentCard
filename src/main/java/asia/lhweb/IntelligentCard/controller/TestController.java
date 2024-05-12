package asia.lhweb.IntelligentCard.controller;

import asia.lhweb.IntelligentCard.mapper.CyAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @author :罗汉
 * @date : 2024/4/23
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Resource
    private CyAdminMapper cyAdminMapper;

    /**
     * 测试redis连接
     */
    @GetMapping("/testRedis")
    public void testRedisConnection() {
        redisTemplate.opsForValue().set("testKey", "testValue",1, TimeUnit.DAYS);
        String value = redisTemplate.opsForValue().get("testKey");
        System.out.println("Value from Redis: " + value);
    }
    //测试自动存session
    @GetMapping("/testSession")
    public void testSession(HttpServletRequest request) {
        request.getSession().setAttribute("testSession", "testSessionValue");
        System.out.println(redisTemplate.opsForValue().get("testSession"));
        System.out.println("----------------------");
        System.out.println(request.getSession().getAttribute("testSession"));
    }

    //测试逻辑删除注解
    @GetMapping("/testLogicalDelete")
    public void testLogicalDelete(Integer id){
        int i = cyAdminMapper.deleteOneById(id);
        System.out.println(i);
    }
}
