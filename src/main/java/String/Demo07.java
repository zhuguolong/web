package String;

public class Demo07 {
    public static void main(String[] args) {
        Long l = 1l;
        Double d = Double.valueOf(2);
        Integer i = 3;

        String str = String.valueOf(l);
        System.out.println(str);

        str = String.valueOf(d);
        System.out.println(str);

        str = String.valueOf(i);
        System.out.println(str);
    }
}
