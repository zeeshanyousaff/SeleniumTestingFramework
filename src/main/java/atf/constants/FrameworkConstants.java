package atf.constants;


import org.aeonbits.owner.Config;

//don't want others to extend this class, therefore, making the class final
public final class FrameworkConstants  {

    //don't want others to create object of this class to access methods, therefore, creating a private constructor.
    private FrameworkConstants() {

    }

    //constant values will not be changed, therefore, keeping them private and final.
    private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/java";
    private static final String CHROMEDRIVERPATH = RESOURCESPATH + "/atf/executables/chromedriver";
    private static final String CONFIGFILEPATH = RESOURCESPATH + "/atf/configurations/config.properties";

    //making the methods static, so that they can be accessed without having to create object of the class.
    public static String getChromeDriverPath() {
        return CHROMEDRIVERPATH;
    }

    public static String getConfigFilePath()

    {
        return CONFIGFILEPATH;
    }
}
