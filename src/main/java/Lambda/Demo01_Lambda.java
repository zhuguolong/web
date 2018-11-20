package Lambda;

/**
 * Lambda表达式
 */
public class Demo01_Lambda {
    public static void main(String[] args) {
        /* 1、第一次 */
        LambdaInterface lambdaInterface01 = new LambdaInterface() {
            @Override
            public int add() {
                return 1 + 9;
            }
        };
        System.out.println("lambdaInterface01.add() = " + lambdaInterface01.add());

        /* 2、第二次 */
        LambdaInterface lambdaInterface02 = () -> {
                return 1 + 9;
        };
        System.out.println("lambdaInterface02.add() = " + lambdaInterface02.add());

        /* 3、第三次 */
        LambdaInterface lambdaInterface03 = () -> 99 + 1;
        System.out.println("lambdaInterface03.add() = " + lambdaInterface03.add());
    }
}
