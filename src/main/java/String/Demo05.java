package String;

public class Demo05 {
    public static void main(String[] args) {
        String str = "12344567,";
        str = str.substring(0, str.length() - 1);
        System.out.println(str);


        String s = "09:00:00";
        String substring = s.substring(0, s.lastIndexOf(":"));
        System.out.println(substring);
    }
}
