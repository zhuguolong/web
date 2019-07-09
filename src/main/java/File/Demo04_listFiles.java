package File;

import java.io.File;

/**
 * @author zhugu
 * 2019/7/9 21:40
 */
public class Demo04_listFiles {
    public static void main(String[] args) {
        File dir = new File("D:\\Develop\\Apache\\apache-maven-3.3.9");
        showDir(dir);
    }

    public static void showDir(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                showDir(file);
            } else {
                System.out.println(file);
            }
        }
    }
}
