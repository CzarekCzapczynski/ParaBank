import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AccountPage;
import scenarios.AddAccountScenario;
import scenarios.LoginScenario;
import scenarios.RegisterScenario;

public class OpenNewAccountTest extends MainTest{
    private final String ACCOUNT_TYPE = "SAVINGS";
    private final String ACCOUNT_KEY = "accountKeyNumber";

    private AccountPage start;
    private String login = getRandomString(5);

    @BeforeClass
    @Parameters({"password", "url"})
    public void beforeClass(String password, String url) {
        before(context, url);
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
    @Parameters({"password"})
    public void beforeTest(String password) {
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
            .run(new AddAccountScenario(ACCOUNT_TYPE, ACCOUNT_KEY))
            .openAccountAssertion.isNewAccountAdded();
    }

//    @Test
//    public void shouldNotLoginNotEnoughMoney() {
//        start
//            .run(new AddAccountScenario("SAVINGS", "17007"))
//                .leftMenu.clickAccountsOverviewLink()
//            .run(new AddAccountScenario("CHECKING", "17007"))
//                .leftMenu.clickAccountsOverviewLink()
//            .run(new AddAccountScenario("SAVINGS", "17007"))
//                .leftMenu.clickAccountsOverviewLink()
//            .run(new AddAccountScenario("CHECKING", "17007"))
//                .leftMenu.clickAccountsOverviewLink()
//            .run(new AddAccountScenario("SAVINGS", "17007"))
//            .openAccountAssertion.isNewAccountNotAdded();
//    }
}
