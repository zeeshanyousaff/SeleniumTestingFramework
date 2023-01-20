package atf.listeners;

import atf.config.ConfigFactory;
import atf.config.FrameworkConfig;
import atf.reports.ExtentManager;
import atf.reports.ExtentReport;
import com.aventstack.extentreports.ExtentTest;
import org.aeonbits.owner.Config;
import org.testng.*;
import java.io.IOException;
import java.util.List;


public class Listener implements ITestListener, ISuiteListener,IMethodInterceptor {


    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initExtentReport();

    }

    @Override
    public void onFinish(ISuite suite) {
        try {
            ExtentReport.flushExtentReport();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.creatTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getExtentTest().pass(result.getMethod().getMethodName()+" is passed");
       // System.out.println((result.getMethod().getMethodName()+"test passed"));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentManager.getExtentTest().pass(result.getMethod().getMethodName()+" is failed");
        //System.out.println((result.getMethod().getMethodName()+"test failed"));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
      //  ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onStart(ITestContext context) {
       // ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
       // ITestListener.super.onFinish(context);
    }

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> list, ITestContext iTestContext) {
        return null;
    }
}
