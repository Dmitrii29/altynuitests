package kz.primesource.pages;


import kz.primesource.base.BasePage;
import kz.primesource.business_objects.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    static Logger logger = LogManager.getLogger(LoginPage.class);

    @FindBy(xpath = "//input[@placeholder='Логин']")
    private WebElement userNameField;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//span[text()='Войти']")
    private WebElement enterButton;
    @FindBy(xpath = "//a[text()='Восстановление пароля']")
    private WebElement passwordRecovery;
    @FindBy(xpath = "//a[text()='Регистрация']")
    private WebElement registration;


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public HomePage loginAs(User user){
        userNameField.click();
        userNameField.sendKeys(user.getUserName());
        logger.debug("username '{}' entered", user.getUserName());
        passwordField.click();
        passwordField.sendKeys(user.getPassword());
        enterButton.click();
        logger.debug("'{}' clicked", enterButton.getText());
        return new HomePage(getDriver());
    }



    public LoginPage loginWithIncorect(User user){
        userNameField.clear();
        userNameField.sendKeys(user.getUserName());
        passwordField.clear();
        passwordField.sendKeys(user.getPassword());
        return this;
    }
}
