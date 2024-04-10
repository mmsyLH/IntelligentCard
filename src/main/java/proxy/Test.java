package proxy;

/**
 * @author :罗汉
 * @date : 2024/4/2
 */
public class Test {
    public static void main(String[] args) {
        Animal animal = new Dog();
        // animal.eat();
        //使用代理
        AnimalProxy animalProxy = new AnimalProxy(animal);
        animalProxy.getProxy().eat();
    }
}
