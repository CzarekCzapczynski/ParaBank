import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import scenarios.AddAccountScenario;
import scenarios.LoginScenario;
import scenarios.RegisterScenario;

public class OpenNewAccountTest extends MainTest{

    private AccountPage start;

    @BeforeMethod
    public void beforeTest() {
        String username = this.getRandomString(5);
        String password = "pass1234";

        start = indexPage
                .run(new RegisterScenario(
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
                .run(new LoginScenario(username, password));
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
