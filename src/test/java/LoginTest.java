import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.IndexPage;

public class LoginTest {
    WebDriver driver;
    IndexPage indexPage;
    AccountPage accountPage;

    public void login (String userName, String password) {
        indexPage.fillUserName(userName);
        indexPage.fillPassword(password);
        indexPage.clickLoginButton();
    }

    @BeforeMethod
    public void before(){
        driver = new ChromeDriver();
        indexPage = new IndexPage(driver);
        accountPage = new AccountPage(driver);
    }

    @Test
    public void shouldLogin() {
        indexPage.openIndexPage();
        indexPage.waitForJStoLoad();
        login("test", "password");
        indexPage.waitForJStoLoad();
        Assert.assertTrue(accountPage.isUserLoggedIn());
    }

    @Test
    public void shouldNotLoginEmptyLogin() {
        indexPage.openIndexPage();
        indexPage.waitForJStoLoad();
        login("", "password");
        indexPage.waitForJStoLoad();
        Assert.assertTrue(indexPage.isErrorDuringLogin(By.cssSelector(".error")));
    }

    @Test
    public void shouldNotLoginEmptyPassword() {
        indexPage.openIndexPage();
        indexPage.waitForJStoLoad();
        login("test", "");
        indexPage.waitForJStoLoad();
        Assert.assertTrue(indexPage.isErrorDuringLogin(By.xpath(
                "//p[contains(.,'Please enter a username and password.')]")));
    }

    @Test
    public void shouldNotLoginBadPassword() {
        indexPage.openIndexPage();
        indexPage.waitForJStoLoad();
        login("test", "test");
        indexPage.waitForJStoLoad();
        Assert.assertTrue(indexPage.isErrorDuringLogin(By.xpath("//p[contains(.,'could not be verified')]")));
    }
}
