package Calendar;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Demo01_Calendar {
    public static void main(String[] args) {
        calendar();
    }

    public static void calendar() {
        Calendar c = Calendar.getInstance();

        System.out.println(c.getTime());
        System.out.println(c.getTimeInMillis());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        String format = sdf.format(new Date());
        String format = sdf.format(c.getTime());
        System.out.println(format);

        //年
        System.out.println(c.get(Calendar.YEAR));
        //月
        System.out.println(c.get(Calendar.MONTH) + 1);
        //日
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        //时
        System.out.println(c.get(Calendar.HOUR_OF_DAY));
        //分
        System.out.println(c.get(Calendar.MINUTE));
        //秒
        System.out.println(c.get(Calendar.SECOND));

        System.out.println(Calendar.getInstance().getTime());
        System.out.println(new Date());

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");

    }
}
