package asia.lhweb.IntelligentCard.servlet;


import com.google.gson.Gson;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 通用servlet
 *
 * @author 罗汉
 * @date 2024/02/26
 */
@WebServlet("/commonServlet")
public class CommonServlet extends BasicServlet {
    private Gson gson = new Gson();// 谷歌的解析json的工具类

    @Override
    public void init() {

    }

    public CommonServlet() {

    }

    /**
     * 上传头像
     *
     * @param request  请求
     * @param response 响应
     * @throws IOException ioexception
     */
    // public void uploadAvatar(HttpServletRequest request, HttpServletResponse response) {
    public void uploadAvatar(HttpServletRequest request, HttpServletResponse response){

    }

    /**
     * 获取md5 STR
     *
     * @param request  请求
     * @param response 响应
     */
    public void getMd5Str(HttpServletRequest request, HttpServletResponse response){

    }


    @Override
    public void destroy() {

    }
}
