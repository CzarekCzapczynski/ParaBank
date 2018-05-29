import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AccountPage;
import scenarios.AddAccountScenario;
import scenarios.LoginScenario;
import scenarios.RegisterScenario;

public class FindTransactionTest extends MainTest{

    private AccountPage start;

    @BeforeClass
    @Parameters({"login", "password", "url"})
    public void beforeClass(String login, String password, String url) {
        before(url);
        indexPage
                .run(new RegisterScenario(
                        "test",
                        "test",
                        "test",
                        "test",
                        "test",
                        "0000",
                        "11",
                        login,
                        password,
                        password))
                .leftMenu.clickLogOutLink();
        after();
    }

    @BeforeMethod
    @Parameters({"login", "password"})
    public void beforeTest(String login, String password) {
        start = indexPage.run(new LoginScenario(login, password));
    }

    @Test
    public void shouldFindTransactionById(){
        start
            .leftMenu.clickfindTransactionLink()
//            .setFindByTransactionIdInput("")
        ;
    }

}
