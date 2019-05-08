package kz.primesource.listeners;


import com.relevantcodes.extentreports.LogStatus;
import kz.primesource.base.BaseTest;
import kz.primesource.utilities.TestUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class CustomListener extends BaseTest implements ITestListener {

    static Logger logger = LogManager.getLogger(CustomListener.class);

    public void onTestStart(ITestResult iTestResult) {
        test = repo.startTest(iTestResult.getName().toUpperCase());
        logger.info("'{}' test started", iTestResult.getName());

    }

    public void onTestSuccess(ITestResult iTestResult) {
        test.log(LogStatus.PASS, iTestResult.getName().toUpperCase() + " PASS");
        repo.endTest(test);
        repo.flush();

    }

    public void onTestFailure(ITestResult iTestResult) {
        logger.error("'{}' test has failed", iTestResult.getName());
            String methodName = iTestResult.getName().toString().trim();
            TestUtil.captureScreenshot(driver, methodName);

        test.log(LogStatus.FAIL, iTestResult.getName().toUpperCase() + " Failed with exception : " + iTestResult.getThrowable());
        test.log(LogStatus.FAIL, test.addScreenCapture( methodName + ".png"));
        repo.endTest(test);
        repo.flush();

    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {
        logger.info("'{}' test finished", iTestContext.getName());
    }

}
