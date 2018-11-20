package toCharArray;

public class ToCharArray {
    public static void main(String[] args) {
        String str = "1234567";
        char[] chars = str.toCharArray();
        System.out.println(chars);
        for(int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

        StringBuffer s = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if (i < chars.length - 1) {
                s.append(chars[i]);
                s.append(",");
            } else {
                s.append(chars[i]);
            }
        }
        System.out.println(s);
    }
}
