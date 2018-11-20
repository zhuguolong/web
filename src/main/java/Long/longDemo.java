package Long;

public class longDemo {
    public static void main(String[] args) {
        long s1 = System.currentTimeMillis();
        calculation();
        long s2 = System.currentTimeMillis();
        long l = s2 - s1;
        System.out.println("执行时间：" + l + "ms");
    }


    private static void calculation() {
        long sum = 0l;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
