package Regular;

/**
 * @author zhugu
 * 2018/11/30 14:10
 */
public class Demo01 {
    public static void main(String[] args) {
        formateCheck();
        hhmmChech();
    }

    // 检查HH:mm:ss
    public static void formateCheck() {
        System.out.println("检查HH:mm:ss");
        String regular = "^(?:[01]\\d|2[0-3])(?::[0-5]\\d){2}$";
        String startTime = "09:00:00";
        String endTime = "22:00:00";

        boolean matches = startTime.matches(regular);
        System.out.println(matches);
        boolean matches1 = endTime.matches(regular);
        System.out.println(matches1);
    }

    // 检查HH:mm
    public static void hhmmChech() {
        System.out.println("检查HH:mm");
        String regular = "^(?:[01]\\d|2[0-3])(?::[0-5]\\d)$";
        String startTime = "09:00";
        String endTime = "00:00";

        boolean matches = startTime.matches(regular);
        System.out.println(matches);
        boolean matches1 = endTime.matches(regular);
        System.out.println(matches1);
    }
}
