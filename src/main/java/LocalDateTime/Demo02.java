package LocalDateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zhugu
 * @version 1.0
 * @Date 2019/2/28 17:06
 */
public class Demo02 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now().minusYears(20);

        LocalDate now1 = LocalDate.now();

        LocalDateTime localDateTime = now1.atStartOfDay();

        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(now));
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime));
    }
}
