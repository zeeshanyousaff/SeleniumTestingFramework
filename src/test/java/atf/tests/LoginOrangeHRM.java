package atf.tests;

import atf.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Objects;

//don't want others to extend this class, therefore, making the class final.
public final class LoginOrangeHRM extends BaseTest {
    //don't want others to create object of this test class to access methods, therefore, creating a private constructor.
    private LoginOrangeHRM() {
    }

    @DataProvider(parallel = true)
    public Object[][] getData() {
        return new Object[][]{{"Admin", "admin123"}, {"Admin", "admin456"}};
    }


    //Never hardcode values
    @Test(dataProvider = "getData")
    protected void loginHRM(String username,String password) throws InterruptedException {

        Thread.sleep(3000);
        DriverManager.getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        DriverManager.getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        DriverManager.getDriver().findElement(By.xpath("//button[@type='submit']")).click();

    }

}