package atf.tests;

import atf.driver.DriverManager;
import atf.readexcel.ReadExcelSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

//don't want others to extend this class, therefore, making the class final.
public final class LoginDataViaExcelSheet extends BaseTest {
    //don't want others to create object of this test class to access methods, therefore, creating a private constructor.
    private LoginDataViaExcelSheet() {
    }

    @DataProvider(parallel = true)
    public Object[][] getData() throws IOException {

        XSSFWorkbook workbook = ReadExcelSheet.readExcelData();
        XSSFSheet sheet = workbook.getSheet("users");
        int rows = sheet.getLastRowNum();
        int columns = sheet.getRow(0).getLastCellNum();  //0 for header row

        Object[][] data = new Object[rows][columns];
        for (int i = 1; i <=rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }

        return data;
    }


    //Never hardcode values
    @Test(dataProvider = "getData")
    protected void loginHRM(String username,String password) throws InterruptedException, IOException {


        DriverManager.getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        DriverManager.getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        DriverManager.getDriver().findElement(By.xpath("//button[@type='submit']")).click();

    }

}