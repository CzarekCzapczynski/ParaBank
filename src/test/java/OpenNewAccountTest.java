import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AccountPage;
import scenarios.AddAccountScenario;
import scenarios.LoginScenario;
import scenarios.RegisterScenario;

public class OpenNewAccountTest extends MainTest{

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
    public void shouldOpenAccountWithoutSettingTypeAndFromAccount(){
        start
            .leftMenu.clickOpenNewAccountLink()
            .clickOpenNewAccountButton()
            .openAccountAssertion.isNewAccountAdded();
    }

    @Test
    public void shouldOpenAccount() {
        start
            .leftMenu.clickOpenNewAccountLink()
            .setAccountType("SAVINGS")
            .setFromAccountId("16563")
            .clickOpenNewAccountButton()
            .openAccountAssertion.isNewAccountAdded();
    }

    @Test
    public void shouldNotLoginNotEnoughMoney() {
        start
            .leftMenu.clickOpenNewAccountLink()
            .run(new AddAccountScenario("SAVINGS", "17007"))
            .leftMenu.clickOpenNewAccountLink()
            .run(new AddAccountScenario("CHECKING", "17007"))
            .leftMenu.clickOpenNewAccountLink()
            .run(new AddAccountScenario("SAVINGS", "17007"))
            .leftMenu.clickOpenNewAccountLink()
            .run(new AddAccountScenario("CHECKING", "17007"))
            .leftMenu.clickOpenNewAccountLink()
            .run(new AddAccountScenario("SAVINGS", "17007"))
            .openAccountAssertion.isNewAccountNotAdded();
    }
}
