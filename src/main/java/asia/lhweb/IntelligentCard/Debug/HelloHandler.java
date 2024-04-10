package asia.lhweb.IntelligentCard.Debug;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloHandler {
    /**
     * @param request * @param response
     * @return
     */
    @RequestMapping(value = "/debug/springmvc")
    public ModelAndView hello(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("name", "罗汉");
        return modelAndView;
    }
}