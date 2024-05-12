package aop;

/**
 * 测试
 *
 * @author 罗汉
 * @date 2024/05/12
 */
public class Test {
    public static void main(String[] args) {
        LoginService loginService=new LoginServiceImpl();
        MyProxyProvider myProxyProvider=new MyProxyProvider(loginService);
        myProxyProvider.getProxy().Login("admin","123456");
    }
}
