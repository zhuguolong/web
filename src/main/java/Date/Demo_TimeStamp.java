package Date;

import java.sql.Timestamp;
import java.util.Date;

public class Demo_TimeStamp {
    public static void main(String[] args) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        System.out.println(timestamp);
    }
}
