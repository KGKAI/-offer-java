package singleton;

// 多线程单例
// 在多线程中，会排队等待获取锁，会造成一定程度上性能的损耗。
// 这样是没有必要的，因为在绝大多数情况下对象已经是创建成功的
public class Singleton3 {
    private static volatile Singleton3 singleton3;

    private Singleton3() {}

    public static Singleton3 getInstance() {
        synchronized (Singleton3.class) {
            if (singleton3 == null) {
                singleton3 = new Singleton3();
            }
        }
        return singleton3;
    }
}
