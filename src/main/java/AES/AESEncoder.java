package AES;

import Utils.AES;

/**
 * 跳转地址：
 * http://htwt.cairenhuitest.com/ehtcPCwealthView?user_token=A811D006D923324F6999BAF0EB54D2423349FA2F142ABC9F48224622DDD033C5
 */
public class AESEncoder {
    public static void main(String[] args) {
        try {
            long second = System.currentTimeMillis() / 1000;
            String encrypt = AES.encrypt("0040174548:" + second, "ht crh dzd ehtc!");
            System.out.println(encrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
