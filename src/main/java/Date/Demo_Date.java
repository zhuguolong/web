package Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo_Date {
    public static void main(String[] args) throws ParseException {
        SDF01();
        System.out.println("------------------------------------------");
        boolean b = SDF02();
        System.out.println(b);
        Date01();
    }

    private static boolean SDF02() throws ParseException {
        boolean flag = false;
        String sTime = "8:00";
        String eTime = "23:00";
        Date date = new Date();
        long currentTime = date.getTime();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf1.format(date);
        String startTime = format + " " + sTime;
        String endTime = format + " " + eTime;
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startDate = sdf2.parse(startTime);
        Date endDate = sdf2.parse(endTime);
        System.out.println(startDate + "    " + endDate);
        long sDate = startDate.getTime();
        long eDate = endDate.getTime();
        if (currentTime > sDate && currentTime < eDate) {
            flag = true;
        }
        return flag;
    }

    private static void SDF01() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date current = new Date();
        current = sdf.parse(sdf.format(current));
        String str = "2018-4-24";
        Date parse = sdf.parse(str);
        System.out.println(current);
        System.out.println(parse);
        if (current.after(parse)) {
            System.out.println("true");
        }
    }

    private static void Date01() throws ParseException {
        String dateStr = "2018-06-21 08:05:30";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parse = sdf.parse(dateStr);
        System.out.println(parse);
    }
}
