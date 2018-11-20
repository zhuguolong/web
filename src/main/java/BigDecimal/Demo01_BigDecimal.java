package BigDecimal;

import java.math.BigDecimal;

public class Demo01_BigDecimal {
    public static void main(String[] args) {
        BigDecimal totalFee = new BigDecimal("111.11");
        BigDecimal rate = new BigDecimal("0.006");
        // 截取
        BigDecimal result = totalFee.multiply(rate).setScale(2, BigDecimal.ROUND_DOWN);
        System.out.println(result);

        // 进位
        result = totalFee.multiply(rate).setScale(2, BigDecimal.ROUND_UP);
        System.out.println(result);
    }
}
