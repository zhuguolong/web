package Exception;

public class Demo01 {
    public static void main(String[] args) {
        try {
            test(9, 0);
        } catch (Exception d) {
            System.out.println(d.getMessage());
        }
    }

    public static void test(int a, int b) {
        double r = a / b;
        System.out.println("r = " + r);
    }
}
