package String;

public class Demo06_null {
    public static void main(String[] args) {
//        nullStr();

        valueOfStr();

        blank();
    }

    public static void valueOfStr() {
        String str = null;
        str = String.valueOf(str);
        System.out.println(str);
    }

    public static void nullStr() {
        String str = null;
        String s = str.toString();
        System.out.println(s);
    }

    public static void blank() {
        String ste = " ";
        System.out.println(ste.length());
    }
}
