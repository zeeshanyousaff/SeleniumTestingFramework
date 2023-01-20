package atf.tests;

import atf.driver.Driver;
import atf.reports.ExtentReport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseTest {

    //don't want others to create object for BaseTest class, therefore, making its constructor protected.
    // Still BaseTest can be extended for uses in test cases.
    protected BaseTest() {
    }
    //Always try to use access modifiers in this way priority wise. Try to keep methods private or protected if possible.
    //private->protected->default---->public
    //Since these methods are to be used only by child classes, therefore, making these methods protected.

    @BeforeMethod
    protected void setup() throws Exception {
        Driver.initDriver();
    }

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
    }
}
