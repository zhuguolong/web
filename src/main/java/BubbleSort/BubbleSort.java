package BubbleSort;

import java.util.Random;

/**
 * 冒泡排序
 */
public class BubbleSort {
    private static int[] arr = {3,2,45,32,0,-1,-90,34,456,76,87,87,456,46,45,674,34,563,46,34,5};

    public static void main(String[] args) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.print(arr[i]);
            }
        }
    }
}
