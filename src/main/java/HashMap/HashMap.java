package HashMap;

public class HashMap {
    /**
     * 静态工厂方法
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> java.util.HashMap<K, V> newInstance() {
        return new java.util.HashMap<K, V>();
    }
}
