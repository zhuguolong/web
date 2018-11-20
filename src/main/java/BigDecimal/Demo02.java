package BigDecimal;

import java.math.BigDecimal;

public class Demo02 {
    public static void main(String[] args) {
        BigDecimal ddd = new BigDecimal("0.0045");
        BigDecimal asdf = ddd.multiply(new BigDecimal("100"));
        String dd = String.valueOf(asdf);
        System.out.println(dd);
    }
}
