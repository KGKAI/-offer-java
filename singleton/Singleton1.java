package singleton;

// 饿汉式
// 在加载类的时候就会创建实例，但是该实例可能并没有使用
// 会在一定程度上造成内存的浪费
public class Singleton1 {
    private static Singleton1 singleton = new Singleton1();

    private Singleton1() {}
    public static Singleton1 getInstance() {
        return singleton;
    }
}
