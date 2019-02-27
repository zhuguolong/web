package LocalDateTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zhugu
 * @version 1.0
 * @Date 2019/2/27 18:47
 */
public class Demo01 {
    public static void main(String[] args) {
        // 今天时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss").format(now));

        // 上周今天时间
        LocalDateTime oneWeeks = now.minusWeeks(1);
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss").format(oneWeeks));
    }
}
