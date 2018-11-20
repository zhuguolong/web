package Excel;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;

public class jxl_createExcel {
    public static void main(String[] args) {
        String title[] = {"id", "name", "sex"};
        File file = new File("D:/input.xls");

        try {
            boolean newFile = file.createNewFile();
            /* 创建工作薄 */
            WritableWorkbook workBook = Workbook.createWorkbook(file);
            /* 创建sheet */
            WritableSheet sheet0 = workBook.createSheet("sheet0", 0);

            Label label = null;
            /* 第一行设置标题 */
            for (int i = 0; i < title.length; i++) {
                /* 列，行，值 */
                label = new Label(i, 0, title[i]);
                /* 添加到单元格 */
                sheet0.addCell(label);
            }
            /* 追加数据：从第二行开始，追加10条记录 */
            for(int i = 1; i < 11; i++) {
                label = new Label(0, i, "a" + i);
                sheet0.addCell(label);
                label = new Label(1, i, "user" + i);
                sheet0.addCell(label);
                label = new Label(2, i, "m");
                sheet0.addCell(label);
            }

            workBook.write();
            workBook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
