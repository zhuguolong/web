package properties;

import java.io.*;
import java.util.Properties;

public class PropertiesUtils {
    /**属性集合对象*/
    private Properties prop;
    /**属性文件输入流*/
    private InputStream fis;
    private OutputStream ois;

    /**
     * 读取配置文件
     */
    public void prop() {
        prop = new Properties();
        /**
         * "/prop.properties"中的"/"不能少
         */
        fis = this.getClass().getResourceAsStream("/prop.properties");
        try {
            /**将属性文件输入流装载到Properties对象中*/
            prop.load(fis);
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");
            System.out.println("username:" + username + "\r\n" + "password:" + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                /**关闭流*/
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
