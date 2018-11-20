package Calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Demo02_Calendar {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();

        c.add(Calendar.DATE, -7);

        Date time = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(time);
        System.out.println(format);
        System.out.println(time);
    }
}
