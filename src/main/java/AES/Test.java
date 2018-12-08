package AES;

/**
 * @author zhugu
 * @version 1.0
 * 2018/12/8 14:21
 */
public class Test {
    public static void main(String[] args) {
        String enPwd = RSA.encryptByPublicKey("123456");
        String result = RSA.decryptByPrivateKey(enPwd);
        System.out.println(result);
    }
}
