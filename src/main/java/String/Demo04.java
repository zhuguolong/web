package String;

public class Demo04 {
    public static void main(String[] args) {
        String str = "123123";
        String[] split = str.split(",");
        for (String s : split) {
            System.out.println(s);
        }
    }
}
