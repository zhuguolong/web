package File;

import java.io.File;

public class Demo01_File {
    public static void main(String[] args) {
        /**
         * 获取某一目录下的所有文件名和目录名
         */
        getFileList();
    }

    private static void getFileList() {
        File file = new File("C:\\Users\\King\\Desktop");
        String[] list = file.list();
        for (String str : list) {
            System.out.println(str);
        }
    }
}
