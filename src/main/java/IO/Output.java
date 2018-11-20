package IO;

import java.io.*;

public class Output {
    public static void main(String[] args) {
        /* 1、创建输出文件 */
        File file = new File("D:/bankbranch.sql");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String text = "select platform_code as platformCode,platform_type as platformType,state,agent,shop_id as merchantId,dial_code_type as dialCodeType,qrc_code as qrcCode,create_time as createTime,create_by as createBy from t_platform p where 1 = 1;";
        text += "\r\n";

        /* 2、写入文件 */
        BufferedOutputStream bos = null;
        try {
            byte[] bytes = text.getBytes();
            int len = text.length();
            for (int i = 0; i < 1000; i++) {
                bos = new BufferedOutputStream(new FileOutputStream(file, true));
                bos.write(bytes, 0, len);
                bos.flush();
            }
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
