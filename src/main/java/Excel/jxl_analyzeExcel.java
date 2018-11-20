package Excel;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

public class jxl_analyzeExcel {
    public static void main(String[] args) {
        try {
            /**创建workbook*/
            Workbook workbook = Workbook.getWorkbook(new File("E:/input.xls"));
            /**获取第一个sheet*/
            Sheet sheet = workbook.getSheet(0);
            /**获取数据*/
            for (int i = 0; i < sheet.getRows(); i++) {
                for (int j = 0; j < sheet.getColumns(); j++) {
                    Cell cell = sheet.getCell(j, i);
                    System.out.print(cell.getContents() + " ");
                }
                System.out.println();
            }

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
