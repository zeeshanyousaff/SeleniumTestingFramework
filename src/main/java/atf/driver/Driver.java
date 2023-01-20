package atf.driver;

import atf.config.ConfigFactory;
import atf.constants.FrameworkConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

    //don't want others to extend this class, therefore, making the class final.
public final class Driver {
    //don't want  others to create object of this class therefore, making a private constructor.
    private Driver() {
    }

    //Note: The default value of thread local (DriverManager.getDriver()) is null so after clean up its value will be null
    //only initiate if driver is null and is not already active. This check is for optimization purpose.
    public static void initDriver() throws Exception {
        if (Objects.isNull(DriverManager.getDriver())) {
              System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
              WebDriver driver = new ChromeDriver();

            // uncomment for running on docker selenium grid
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setBrowserName("chrome");
//            WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            DriverManager.setDriver(driver);
            //DriverManager.getDriver().get(ReadPropertyFile.getValue("url"));
            DriverManager.getDriver().get(ConfigFactory.getConfig().url());
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) //only quit if driver is not null and is already active. This check is for optimization purpose.
        {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

}
