package atf.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

    private static ThreadLocal<ExtentTest> extTest=new ThreadLocal<>();


    public static ExtentTest getExtentTest() {
        return extTest.get();
    }

    public static void setExtentTest(ExtentTest test) {
        extTest.set(test);
    }

    public static void unload()
    {
        extTest.remove();
    }
}

//to handle issue with report generation for parallell test case execution.
