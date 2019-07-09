package Demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author zhugu
 * 2019/1/27 21:27
 */
public class Demo {
    public static void main(String[] args) {
//        random(7, 201);
//        Rand("565", 7, new BigDecimal("150.00"), new BigDecimal("10000.00"));

        List<Integer> list = split(540, new ArrayList<Integer>());

        for(int nub : list){

            System.out.println(nub);

        }
    }

    public static void Rand(String moneyStr, long r, BigDecimal low, BigDecimal up) {
        double money = Double.parseDouble(moneyStr);
        if (money % 1 == 0) {
            // 整数
            System.out.println("整数");
        } else {
            // 小数
            System.out.println("小数");
        }
        System.out.println(money);
    }

    public static void random(int n, int L){
        Random rand = new Random();
        int temp = L;
        for(int i = 0, j; i < n - 1; i++){
            j = rand.nextInt(temp - 1) + 1;
            temp -= j;
            System.out.println(j);
        }
        System.out.println(temp);
    }

    /**

     * 自动随机分拆，传入一个数分拆成5000至45000之间的数

     * @param num:需要分拆的数

     * @param list

     * @return

     */

    static List<Integer> split(int num, List<Integer> list){

        Random r = new Random();

        int n = num / 200 + 1;

        int numm = 0;

        for(int i = 1;i < n; i++){

            int next = r.nextInt(10000) + 150;

            list.add(next);

            numm+=next;

        }

        if(num - numm > 5000){

            split(num-numm,list);

        }else{

            list.add(num-numm);

        }

        return list;

    }
}
