package Timestamp;

import java.sql.Timestamp;
import java.util.Calendar;

public class Demo_Timestamp {
    public static void main(String[] args) {
        Timestamp t1 = new Timestamp(Calendar.getInstance().getTimeInMillis());
        System.out.println(t1);
        Timestamp t2 = new Timestamp(System.currentTimeMillis());
        System.out.println(t2);
        System.out.println("----------------------------");
        Timestamp t3 = new Timestamp(Calendar.getInstance().getTimeInMillis() + 60 * 1000);
        System.out.println(t3);

    }
}
