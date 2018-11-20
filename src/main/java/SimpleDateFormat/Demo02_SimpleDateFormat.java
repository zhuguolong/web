package SimpleDateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo02_SimpleDateFormat {
    public static void main(String[] args) {
        simpleDateFormat();
    }

    public static void simpleDateFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String format = sdf.format(new Date());
        System.out.println(format);
    }
}
