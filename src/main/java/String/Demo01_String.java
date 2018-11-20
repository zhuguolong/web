package String;

public class Demo01_String {
    public static void main(String[] args) {
        String mobile = "18845265489";
        String dd = mobile.substring(0, 3) + "****" + mobile.substring(7, mobile.length());
        System.out.println(dd);

        String idNo = "340321199401126577";
        String idNo_view = idNo.substring(0, 6) + "**********" + idNo.substring(16, idNo.length());
        System.out.println(idNo_view);
    }
}
