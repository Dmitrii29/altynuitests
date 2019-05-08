package kz.primesource.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;

public class ChromeWebdriver {

    static Logger logger = LogManager.getLogger(ChromeWebdriver.class);

    private static WebDriver driver;

    private ChromeWebdriver(){

    }

    public static WebDriver getInstance() throws MalformedURLException {
        if (driver==null) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/executables/chromedriver");
            driver = new ChromeDriver();
        }
        return driver;
    }
}
