package AES;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
/**
 * @author zhugu
 * @version 1.0
 * 2018/12/8 16:34
 */
public class Tester {
    public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        String string = AESCipher.aesEncryptString("123456", "sh huishu Jiulc!");
        System.out.println(string);
        System.out.println(AESCipher.aesDecryptString(string, "sh huishu Jiulc!"));
    }
}
