package atf.tests;


import atf.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

//don't want others to extend this class, therefore, making the class final.
public final class HomePageTest extends BaseTest {
    //don't want others to create object of this test class to access methods, therefore, creating a private constructor.
    public HomePageTest() {
    }


    @Test
    protected void googleHomePage() {

        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Maven", Keys.ENTER);

    }


}
