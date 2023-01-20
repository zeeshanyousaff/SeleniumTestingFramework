package atf.readexcel;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelSheet
{
    public static XSSFWorkbook readExcelData() throws IOException {

        File file = new File(System.getProperty("user.dir") + "/Testdata.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        return workbook;

    }
}
