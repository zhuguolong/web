package RSA;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

/**
 * @author zhugu
 * @version 1.0
 * 2018/12/8 10:29
 */
public class RSAUtil {
    /**
     * The constant that denotes the algorithm being used.
     */
    private static final String algorithm = "RSA";

    /**
     * The private constructor to prevent instantiation of this object.
     */
    private RSAUtil() {

    }

    /**
     * The method that will create both the public and private key used to encrypt and decrypt the data.
     *
     * @param publicKeyOutput
     * 		The path of where the public key will be created.
     *
     * @param privateKeyOutput
     * 		The path of where the private key will be created.
     *
     * @return {@code true} If this operation was successful, otherwise {@code false}.
     */
    public static boolean generateKey(String publicKeyOutput, String privateKeyOutput) {
        try {
            final KeyPairGenerator keyGen = KeyPairGenerator.getInstance(algorithm);
            keyGen.initialize(2048);

            final KeyPair key = keyGen.generateKeyPair();

            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(publicKeyOutput)))) {
                dos.write(key.getPublic().getEncoded());
            }

            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(privateKeyOutput)))) {
                dos.write(key.getPrivate().getEncoded());
            }

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * The method that will encrypt an array of bytes.
     *
     * @param key
     * 		The public key used to encrypt the data.
     *
     * @param data
     * 		The data in the form of bytes.
     *
     * @return The encrypted bytes, otherwise {@code null} if encryption could not be performed.
     */
    public static byte[] encrypt(PublicKey key, byte[] data) {
        try {

            final Cipher cipher = Cipher.getInstance(algorithm);

            cipher.init(Cipher.ENCRYPT_MODE, key);

            return cipher.doFinal(data);

        } catch (Exception ex) {

        }

        return null;

    }

    /**
     * The method that will decrypt an array of bytes.
     *
     * @param key
     * 		The {@link PrivateKey} used to decrypt the data.
     *
     * @param encryptedData
     * 		The encrypted byte array.
     *
     * @return The decrypted data, otherwise {@code null} if decryption could not be performed.
     */
    public static byte[] decrypt(PrivateKey key, byte[] encryptedData) {

        try {

            final Cipher cipher = Cipher.getInstance(algorithm);

            cipher.init(Cipher.DECRYPT_MODE, key);

            return cipher.doFinal(encryptedData);

        } catch (Exception ex) {

        }

        return null;

    }

    /**
     * The method that will re-create a {@link PublicKey} from a serialized key.
     *
     *
     * @param publicKeyPath
     * 		The path of the public key file.
     *
     * @throws Exception
     * 		If there was an issue reading the file.
     *
     * @return The {@link PublicKey} object.
     */
    public static PublicKey getPublicKey(String publicKeyPath) throws Exception {
        return KeyFactory.getInstance(algorithm).generatePublic(new X509EncodedKeySpec(Files.readAllBytes(Paths.get(publicKeyPath))));
    }

    /**
     * The method that will re-create a {@link PrivateKey} from a serialized key.
     *
     *
     * @param privateKeyPath
     * 		The path of the private key file.
     *
     * @throws Exception
     * 		If there was an issue reading the file.
     *
     * @return The {@link PrivateKey} object.
     */
    public static PrivateKey getPrivateKey(String privateKeyPath) throws Exception {
        return KeyFactory.getInstance(algorithm).generatePrivate(new PKCS8EncodedKeySpec(Files.readAllBytes(Paths.get(privateKeyPath))));
    }

    /**
     * The method that will re-create a {@link PublicKey} from a public key byte array.
     *
     * @param encryptedPublicKey
     * 		The byte array of a public key.
     *
     * @throws Exception
     * 		If there was an issue reading the byte array.
     *
     * @return The {@link PublicKey} object.
     */
    public static PublicKey getPublicKey(byte[] encryptedPublicKey) throws Exception {
        return KeyFactory.getInstance(algorithm).generatePublic(new X509EncodedKeySpec(encryptedPublicKey));
    }

    /**
     * The method that will re-create a {@link PrivateKey} from a private key byte array.
     *
     *
     * @param encryptedPrivateKey
     * 		The array of bytes of a private key.
     *
     * @throws Exception
     * 		If there was an issue reading the byte array.
     *
     * @return The {@link PrivateKey} object.
     */
    public static PrivateKey getPrivateKey(byte[] encryptedPrivateKey) throws Exception {
        return KeyFactory.getInstance(algorithm).generatePrivate(new PKCS8EncodedKeySpec(encryptedPrivateKey));
    }


    /**
     * 随机生成RSA密钥对
     *
     * @param keyLength
     *            密钥长度，范围：512～2048<br>
     *            一般1024
     * @return
     */
    public static KeyPair generateRSAKeyPair(int keyLength)
    {
        try
        {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(keyLength);
            return kpg.genKeyPair();
        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        KeyPair a=  generateRSAKeyPair(1024);
        byte[] pr=a.getPrivate().getEncoded();
        String prkey=Base64Utils.encode(pr);
        System.out.println("私钥："+prkey);
        byte[] pu=a.getPublic().getEncoded();
        String pukey=Base64Utils.encode(pu);
        System.out.println("公钥："+pukey);

        System.out.println("明文：");
        String value = "123456";
        byte[] en = encrypt(  getPublicKey(Base64Utils.decode(pukey)), value.getBytes());
//       byte[] en = encrypt(  getPublicKey(pu), value.getBytes());
        System.out.println(value);
        System.out.println("加密后：");
        String c  =Base64Utils.encode(en);
        System.out.println(c);
        System.out.println("解密后：");
        System.out.println(new String(decrypt( getPrivateKey(Base64Utils.decode(prkey)),Base64Utils.decode(c))));

    }
}
