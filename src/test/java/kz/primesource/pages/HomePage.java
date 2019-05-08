package kz.primesource.pages;

import kz.primesource.base.BasePage;
import kz.primesource.base.BaseTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    static Logger logger = LogManager.getLogger(HomePage.class);

    @FindBy(xpath = "//h3[text()='Избранное']")
    private WebElement izbrannoe;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getIzbrannoe() {
        return izbrannoe;
    }
}
