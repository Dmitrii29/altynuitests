package kz.primesource.tests.loginTests;


import kz.primesource.base.BaseTest;
import kz.primesource.business_objects.User;
import kz.primesource.pages.HomePage;
import kz.primesource.pages.LoginPage;
import kz.primesource.utilities.DataProviderClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPositiveTest extends BaseTest {

    @Test(dataProvider = "dataForLoginTest", dataProviderClass = DataProviderClass.class)
    public void loginTest(User user){
        HomePage homePage = PageFactory.initElements(driver, LoginPage.class).loginAs(user);
        Assert.assertEquals(homePage.getIzbrannoe().getText(), "ИЗБРАННОЕ");
    }
}
