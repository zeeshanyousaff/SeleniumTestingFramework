package atf.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public final class ExtentReport {

    private ExtentReport()
    {

    }

    private static ExtentReports extent;

    public static void initExtentReport()
    {
        //setup
        extent= new ExtentReports();
        ExtentSparkReporter spark=new ExtentSparkReporter("Report/extentreport.html");
        extent.attachReporter(spark);

        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation Testing Framework Execution Report");
        spark.config().setReportName("Login Execution Results");

    }

    public static void flushExtentReport() throws IOException {
        extent.flush();
        Desktop.getDesktop().browse(new File("Report/extentreport.html").toURI()); // will automatically open report after execution.
    }

    public static void creatTest(String testcasename)
    {
        extent.createTest(testcasename);
    }







}
