package aop;

/**
 * @author :罗汉
 * @date : 2024/5/12
 */
public class LoginServiceImpl implements LoginService{
    @Override
    public String Login(String account, String password) {
        // 业务逻辑判断 ....
        // System.out.println(1/0);

        return "登录成功";
    }
}
