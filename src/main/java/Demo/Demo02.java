package Demo;

import java.util.Random;

/**
 * @author zhugu
 * 2019/1/27 22:04
 */
public class Demo02 {
    static boolean getArray(int n,int l,int sum,int []a) {

        for (int i = 0; i < l; i++) {
            a[i] = 0;
        }
        Random rand = new Random();
        for (int i = 0; i < l-1; i++) {
            a[i] = rand.nextInt(n - sum) + 1;
            sum = sum + a[i];
            if (sum >= n) {
                return false;
            }
        }
        a[l-1]=n-sum;
        return true;
    }

    public static void main(String[] args) {
        int n = 5897;
        int l = 6;
        int sum = 0;
        int[] a = new int[l];
        while (!getArray(n,l,sum,a)) {
            getArray(n,l,sum,a);
        }
        for (int i = 0; i < l; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
