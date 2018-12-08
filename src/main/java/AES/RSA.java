package AES;

import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

/**
 * RSA工具类
 * Created by kouyi on 2017/9/27.
 */
public class RSA {
    private static final int KEYSIZE = 2048;
    private static final String ENCODE = "UTF-8";
    private static final String ALGORITHM_ = "RSA";
    private static final String PUBLICKEY = "PUBKEY";
    private static final String PRIVATEKEY = "PRIKEY";

    //客户端私钥
    private static final String CLIENT_PRIKEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCSMCSJ7wlm9nxUmxcaMZOrgw+iEcbjzyfRJ6hunKlq2aRWF5qifvtzZxequ+x80EuP9jkD9u7sU/5XvE2AUz0b5HxL9zbA8DsGDE2pY0Z4u30IgJktDSd6cvOdvNcMDV1qdp9LDHhzhz+UqbW1s9hkXRnAG9Xh1cJosA+JJxzwRKafxgcklHcYytjmfwXVNlECYTt/W3ATKhEHKwXiqx7YzwMoh1lU76wWcnQ5zxt2naMFVG8GcCZUs4ztzqolpeOKWGS3soARlQX0FSaR90QkYCjmFAL13nacSd5JrAXdGyF4KsoUGtdrDJ4Syj4DiBMkYKYPeVdMOKnZc4VcxV7xAgMBAAECggEAO4GXTgJcTGonH/VliQcHOjiGQ42C7TZk2dGP0T66A8GGEHlZO63+wvIDAz+tuvy61WX/vWplxRNHpAUFcyfu5wyxv+Zohk8DZ6nYbwv3IqwG8FAQifMhz8k8+0dkLga+sNiKbO0tlrFGI0iVq9oCSpBPLBDolh4CHcUU/dpLAE3+7k7NsGjZ2dc3eeTA8+7y74SyAfaeqm+/0lv/BKF1v5eeDs9zw89sedg2TLIztGSgKowc+wxJi3dbvsXok8nFgjso/zapkfpDCYH13cmiMBlwqJWlP7d71WqLAXFEEdosqnhj+QLRst/vE8GJw8CUnSGawMlHlRootYzkhsAZhQKBgQD5zmSfpOrY9BTmWHtqEB7Ml2cYr/6S3beZJbVyQzh3JIdGVuzmB1vUVG9jf6CWkis2PA1xdIuQtuR4nvlHlzobl6q+zfGY4MgP2F/wkPPDfp8BOyWb3fG1CgkMu+CQg+8JntrNqIi3/ZbXJSm1XyvfkFqej7pYlsiM/mvpeo7JuwKBgQCV0AyVMbJ7cjqVkNLXdjYciJ0r99frt8K6poypZArUTDIIvY1CdJgcQ1z9nziQBLJoV2yhtAFPXUtFuj9/T0ii+TT7ddpYS70vV7kYBxBrWxvNwokCjzCijCfr+PuMz2LwxrbdDkIwQyw7S7P/5t5hkP0xNdXPtktjuhbqDH0JQwKBgDR4u/4koAfuTS2NTG8c77s92jP/U9P5qoUKvLBBmmy8SYXm4F/5D7rr+XHG7y5xiY4c0x4Pwvkk0Zzcl7QH+fatxvnJPIRGQv/BDXX0nJ9ly3RwvhedaRYEA56fIC566Az3RzKHwiATrkmGztoAIbEWG1LPEe9lzL6A+p3SVofdAoGAYYnEN3rU1tSnWeuhqpCXaHp1wkOqPBk3WmjHWh39gv1c8h3fk63vvy8Io0QAApxcP9zzqFBXLgHy2SIK52uKQjl4imPP1f7x3JoDs6YdxZfbAVsv8w+hPaN89oDz3ljD9Tmbo07+PwftC2oddnYswV8xydFgNM1eRj7JXnblDZsCgYB1+ablWigGWUjeMGLYrDZjF+Jvet6a6FyOH4XV3W3FRnlw8xcAfoEJ286uWih4gQzFfDEVPLdTcZJQltoagOwyzXWJL2q9/ZkqIr0XxEzSrBQVUtuwmEJIbdvgvp8eBCmqm67NWoSJ/qpv3wT5vgv3TtJ8gculQmMJ0NHjN5fW5A==";
    //客户端公钥
    private static final String CLIENT_PUBKEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuFPdRBaE6OnqQsXvVim5mOmXhXidOa16gLIV9sI2dRZW4ZejlE+zGIsAlbsDYagO+RkjgVeZd4oZ+P7roYNlLtY8YujNkMnhMqHHKAOXUqK6HMBzrCsu/JaMFNsYW7EyEnXnd1Lq15U85O1irXLYfBbrGjKrYlKv5p+3xUYKRRc+PdeYDCKPKLKl9vgZwACVYnYEEuM2ErxdYWRARukSIEOtO69X6C1xlJL+MnQlFMTWLvg2m3pvAHqa/ZMJLwFE9mf+29LnjAJJvPWjMCUGroU0Hjoq+cPTJp5EfPM6jHlIhHzl8oZCHvNRFgOkXz5aFqNbmg5m0vs8vugBGXN61wIDAQAB";

    /**
     * RSA私钥解密
     * @param data
     * @return
     * @throws Exception
     */
    public static String decryptByPrivateKey(String data) {
        try {
            byte[] keyBytes = Base64Util.decodeToByte(CLIENT_PRIKEY);
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_);
            Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
            //对数据解密
            //公钥生成的密文相同 Cipher cipher = Cipher.getInstance(TRANSFORMATION, new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return new String(cipher.doFinal(Base64Util.decodeToByte(data)), ENCODE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * RSA公钥加密
     * @param data
     * @return
     */
    public static String encryptByPublicKey(String data) {
        try {
            byte[] keyBytes = Base64Util.decodeToByte(CLIENT_PUBKEY);
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_);
            Key publicKey = keyFactory.generatePublic(x509KeySpec);
            //对数据加密
            //公钥生成的密文相同 Cipher.getInstance(TRANSFORMATION, new BouncyCastleProvider());
//            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return Base64Util.encodeByte(cipher.doFinal(data.getBytes(ENCODE)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
