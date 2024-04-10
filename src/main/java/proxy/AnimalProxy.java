package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author :罗汉
 * @date : 2024/4/2
 */
public class AnimalProxy {
    // 定义一个属性
    private Animal animal;

    public AnimalProxy(Animal animal) {
        this.animal = animal;
    }

    /**
     * 获取一个动物对象的代理实例。
     * 该代理实例在调用任何方法时，会在方法执行前后打印出"代理开始"和"代理结束"的字样。
     *
     * @return 返回代理后的动物对象，该对象在方法调用时会附加额外的操作。
     */
    public Animal getProxy() {
        // 获取动物对象实现的接口列表
        Class<?>[] interfaces = animal.getClass().getInterfaces();

        // 创建一个动态代理的调用处理器
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 在方法执行前打印开始信息
                System.out.println("代理开始");
                // 调用原始方法，并获取执行结果
                Object o = method.invoke(animal, args);
                // 在方法执行后打印结束信息
                System.out.println("代理结束");
                return o;
            }
        };

        // 使用动态代理生成一个新的动物对象实例，该实例会使用上述的调用处理器
        Animal animalProxy = (Animal) Proxy.newProxyInstance(animal.getClass().getClassLoader(), interfaces, invocationHandler);

        return animalProxy;
    }

}
