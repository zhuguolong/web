package Token;

public class Demo {
    public static void main(String[] args) {
        long userId = 1354354;
        String phone = "18511111111";
        String token = TokenUtils.createToken(userId, phone);
        System.out.println(token);

        long userId1 = TokenUtils.getUserId(token);
        System.out.println(userId1);

        String phone1 = TokenUtils.getPhone(token);
        System.out.println(phone1);
    }
}
