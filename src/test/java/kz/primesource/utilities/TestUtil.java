package kz.primesource.utilities;

import kz.primesource.base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;



public class TestUtil extends BaseTest {
    static Logger logger = LogManager.getLogger(TestUtil.class);
    public static  void captureScreenshot(WebDriver driver, String methodName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(takesScreenshot.getScreenshotAs(OutputType.FILE),
                    new File(System.getProperty("user.dir")+"/target/surefire-reports/html/" + methodName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("Screenshot for {} taken", methodName);

    }


}
