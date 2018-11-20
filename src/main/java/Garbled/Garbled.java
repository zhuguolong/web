package Garbled;

public class Garbled {
    public static void main(String[] args) {
//        String str = "ææè±å¸å¬å®å±è¥¿åºåå±";
        String str = "分享件时尚的款式都是";
        str = str.trim();
        String after = str.replaceAll("[^\\x00-\\xff]", "11");
        int length = after.length();
        System.out.println(length);
    }
}
