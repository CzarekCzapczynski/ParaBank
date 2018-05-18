import org.testng.annotations.Test;
import scenarios.LoginScenario;
import scenarios.RegisterScenario;

public class LoginTest extends MainTest{

//    public void login (String userName, String password) {
//        indexPage.setUserName(userName);
//        indexPage.setPassword(password);
//        indexPage.clickLoginButton();
//    }

    @Test
    public void shouldLogin() {
        String username = "newUser";
        String password = "pass1234";

        indexPage.run(new RegisterScenario(
                "test",
                "test",
                "test",
                "test",
                "test",
                "0000",
                "11",
                username,
                password,
                password))
                .logout()
                .run(new LoginScenario(username, password))
            .loginAssertion.isUserLoggedIn();
    }

    @Test
    public void shouldNotLoginEmptyLogin() {
        indexPage.run(new LoginScenario("", "password"))
            .loginAssertion.isUserNotLoggedIn();
    }

    @Test
    public void shouldNotLoginEmptyPassword() {
        indexPage.run(new LoginScenario("test", ""))
                .loginAssertion.isErrorDisplayed("Please enter a username and password.");
    }

    @Test
    public void shouldNotLoginBadPassword() {
        indexPage.run(new LoginScenario("test", "test"))
                .loginAssertion.isErrorDisplayed("The username and password could not be verified.");
    }
}
