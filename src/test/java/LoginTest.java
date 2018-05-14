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
    }

    @Test
    public void shouldNotLoginEmptyLogin() {
        indexPage.openIndexPage()
            .setUserName("")
            .setPassword("password")
            .clickLoginButton()
            .loginAssertion.isUserNotLoggedIn();
    }

    @Test
    public void shouldNotLoginEmptyPassword() {
        indexPage.openIndexPage()
                .setUserName("test")
                .setPassword("")
                .clickLoginButton()
                .loginAssertion.isErrorDisplayed("Please enter a username and password.");
    }

    @Test
    public void shouldNotLoginBadPassword() {
        indexPage.openIndexPage()
                .setUserName("test")
                .setPassword("test")
                .clickLoginButton()
                .loginAssertion.isErrorDisplayed("The username and password could not be verified.");
    }
}
