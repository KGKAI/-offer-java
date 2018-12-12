package singleton;

// 多线程单例模式，双重校验机制
public class Singleton4 {
    private Singleton4() {}

    private static volatile Singleton4 singleton4;

    public static Singleton4 getInstance() {
        if (singleton4 == null) {
            synchronized (Singleton4.class) {
                if (singleton4 == null) {
                    singleton4 = new Singleton4();
                }
            }
        }

        return singleton4;
    }
}
