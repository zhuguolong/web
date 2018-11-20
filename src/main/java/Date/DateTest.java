package Date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

/**
 * Description JDK8中处理日期和时间的类
 */
public class DateTest {
    public static void main(String[] args) {
        test01();
        System.out.println("······························");
        test02();
    }

    /* 处理日期LocalData */
    private static void test01() {
        /* 1、获取当前日期 */
        LocalDate now = LocalDate.now();
        System.out.println("获取当前日期：" + now);

        /* 2、构造日期 */
        LocalDate of = LocalDate.of(2018, 10, 9);
        System.out.println("构造日期：" + of);
        LocalDate parse = LocalDate.parse("2018-09-09");
        System.out.println(parse);

        /* 3、本月第1天 */
        LocalDate firstDayOfMonth = now.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("本月第1天：" + firstDayOfMonth);
        /* 4、本月第2天 */
        LocalDate withDayOfMonth = now.withDayOfMonth(2);
        System.out.println("本月第2天：" + withDayOfMonth);
    }

    /* 处理时间LocalTime */
    private static void test02() {
        /* 1、获取当前时间 含毫秒值 17:18:41.571 */
        LocalTime now = LocalTime.now();
        System.out.println("获取当前时间 含毫秒值：" + now);

        /* 2、获取当前时间 无毫秒值 17:45:41 */
        LocalTime localTime = LocalTime.now().withNano(0);
        System.out.println("获取当前时间 无毫秒值：" + localTime);

        /* 3、标准时间 2017-11-06T17:53:15.930 */
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("标准时间：" + localDateTime);
    }
}
