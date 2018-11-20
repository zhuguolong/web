package File;

import java.io.*;
import java.util.Scanner;

public class Demo02_File {
    public static double Entropy(String str) {
        double H = .0;
        int sum = 0;
        int[] letter = new int[26];//26个字符
        str = str.toUpperCase(); // 将小写字母转换成大写
        for (int i = 0; i < str.length(); i++) { // 统计字母个数
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                letter[c - 'A']++;
                sum++;
            }
        }
        System.out.println("sum = " + sum);
        //计算信息熵，将字母出现的频率作为离散概率值
        for (int i = 0; i < 26; i++) {
            double p = 1.0 * letter[i] / sum;//单个字母的频率
            System.out.println("p = " + p);
            if (p > 0) {
                H += -(p * Math.log(p) / Math.log(2));// H = -∑Pi*log2(Pi)
            }
        }
        return H;
    }

    public static void main(String[] args) throws IOException {
//        System.out.println("请输入字符串：");
//        Scanner scan = new Scanner(System.in);
//        String str = scan.next();
//        double H = Entropy(str);
//        System.out.printf("%4.2f\n", H);

        File file = new File("C:\\Users\\zhugu\\Desktop\\aaa.txt");
        FileInputStream in = new FileInputStream(file);
        int len = 0;
        byte[] buf = new byte[1024];
        StringBuffer sb = new StringBuffer("");
        while((len = in.read(buf)) != -1){
            sb.append(new String(buf, 0, len));
        }
        System.out.println(sb);
        double entropy = Entropy(sb.toString());
        System.out.println(entropy);
    }
}
