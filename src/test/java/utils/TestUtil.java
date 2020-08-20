package selenium;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil {
    public static Workbook workbook;
    public static Sheet sheet;
    public static String TEST_DATA_SHEET = System.getProperty("user.dir") + "/src/test/java/selenium/TestData.xlsx";

    public static Object[][] readDataFromExcelFile(String sheetName) {
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(TEST_DATA_SHEET);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workbook = WorkbookFactory.create(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = workbook.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                System.out.println(" row data" + sheet.getRow(0).getRowNum());
                System.out.println("cell data" + sheet.getRow(0).getCell(1));
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
            }
        }
        return data;

    }


}
