import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import scenarios.LoginScenario;

public class AccountTest extends MainTest{

    private AccountPage start;

    @BeforeMethod
    public void beforeTest(){
        start = indexPage.run(new LoginScenario("usertest", "pass"));
    }

    @Test
    public void shouldAddAccount(){
        start.loginAssertion.isUserLoggedIn();
    }

}
