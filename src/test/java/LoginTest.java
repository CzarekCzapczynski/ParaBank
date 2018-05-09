import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends MainTest{

//    public void login (String userName, String password) {
//        indexPage.setUserName(userName);
//        indexPage.setPassword(password);
//        indexPage.clickLoginButton();
//    }

    @Test
    public void shouldLogin() {
        indexPage.openIndexPage()
            .setUserName("test")
            .setPassword("password")
            .clickLoginButton()
            .loginAssertion.isUserLoggedIn();

//        Assert.assertTrue(accountPage.isUserLoggedIn());
    }

    @Test
    public void shouldNotLoginEmptyLogin() {
        indexPage.openIndexPage()
            .setUserName("")
            .setPassword("password")
            .clickLoginButton();

        Assert.assertTrue(indexPage.isErrorDuringLogin(By.cssSelector(".error")));
    }

    @Test
    public void shouldNotLoginEmptyPassword() {
        indexPage.openIndexPage()
                .setUserName("test")
                .setPassword("")
                .clickLoginButton();

        Assert.assertTrue(indexPage.isErrorDuringLogin(By.xpath(
                "//p[contains(.,'Please enter a username and password.')]")));
    }

    @Test
    public void shouldNotLoginBadPassword() {
        indexPage.openIndexPage()
                .setUserName("test")
                .setPassword("test")
                .clickLoginButton();

        Assert.assertTrue(indexPage.isErrorDuringLogin(By.xpath("//p[contains(.,'could not be verified')]")));
    }
}
