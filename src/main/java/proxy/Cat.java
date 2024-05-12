package proxy;

/**
 * @author :罗汉
 * @date : 2024/4/2
 */
public class Cat implements Animal{
    @Override
    public void eat() {
        System.out.println("猫吃猫粮");
    }

    @Override
    public String drink() {
        return null;
    }
}
