package singleton;

public class Singleton5 {
    private Singleton5() {}

    private static class SingletonHolder {
        public static Singleton5 singleton5 = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return SingletonHolder.singleton5;
    }
}
