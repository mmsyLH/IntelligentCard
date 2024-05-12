package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 代理提供商
 *
 * @author 罗汉
 * @date 2024/05/12
 */
public class MyProxyProvider {
    private LoginService loginService;

    public MyProxyProvider(LoginService loginService) {
        this.loginService = loginService;
    }

    // 方法 返回代理对象，该代理对象可以执行目标对象的方法
    public LoginService getProxy() {
        // 1.先得到类加载器对象
        ClassLoader classLoader = loginService.getClass().getClassLoader();

        // 2.得到要执行的目标对象的接口信息
        Class[] interfaces = loginService.getClass().getInterfaces();

        // 3.创建一个动态代理的调用处理器
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object res = null;
                try {
                    System.out.println("方法执行前-日志-方法名：" + method.getName() + "参数：" + Arrays.asList(args));
                    // 使用反射调用方法
                     res = method.invoke(loginService, args);
                    System.out.println("方法执行后-日志-方法名：" + method.getName() + "结果：" + res);

                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("方法执行异常-日志-方法名：" + method.getName() + "异常类型：" + e.getClass().getName());
                } finally {
                    System.out.println("方法最终结束-日志-方法名："+ method.getName());
                }
                return res;
            }
        };

        //创建代理对象
        LoginService proxy = (LoginService) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        return proxy;
    }


}
