package kz.primesource.base;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import kz.primesource.utilities.ChromeWebdriver;
import kz.primesource.utilities.ExcelReader;
import kz.primesource.utilities.ExtentManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public static Properties config = new Properties();
    static Logger logger = LogManager.getLogger(BaseTest.class);
    public ExtentReports repo = ExtentManager.getInstance();
    public static ExtentTest test;
    public SoftAssert softAssert = new SoftAssert();
    public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "/src/test/resources/excelData/uccTest.xlsx");

    @BeforeSuite
    public void setUp() throws MalformedURLException {


        if (driver == null) {
            try {

                config.load(new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/Config.properties"));
                logger.debug("config file loaded.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/executables/chromedriver.exe");

                driver = ChromeWebdriver.getInstance();

        }

        driver.manage().window().maximize();
        driver.get(config.getProperty("url"));
        logger.debug("navigated to: " + config.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitlyWait")), TimeUnit.SECONDS);


    }

    @AfterSuite
    public void TearDown() {
        if (driver != null) {
            driver.quit();
        }
        logger.debug("test execution completed.");

    }
}
