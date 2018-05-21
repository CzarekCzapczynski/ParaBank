import org.testng.annotations.Test;
import scenarios.AddAccountScenario;
import scenarios.LoginScenario;
import scenarios.RegisterScenario;

public class OpenNewAccountTest extends MainTest{

    @Test
    public void shouldOpenAccountWithoutSettingTypeAndFromAccount(){
        String username = this.getRandomString(5);
        String password = "pass1234";

        indexPage
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
                .run(new LoginScenario(username, password))
                .leftMenu.clickOpenNewAccountLink()
                .clickOpenNewAccountButton()
                .openAccountAssertion.isNewAccountAdded();
    }

    @Test
    public void shouldOpenAccount() {
        String username = this.getRandomString(5);
        String password = "pass1234";

        indexPage
                .run(new RegisterScenario(
                        "test1",
                        "test1",
                        "test1",
                        "test1",
                        "test1",
                        "0000",
                        "11",
                        username,
                        password,
                        password
                ))
                .logout()
                .run(new LoginScenario(
                        username,
                        password
                ))
                .leftMenu.clickOpenNewAccountLink()
                .setAccountType("SAVINGS")
                .setFromAccountId("16563")
                .clickOpenNewAccountButton()
                .openAccountAssertion.isNewAccountAdded();
    }

    @Test
    public void shouldNotLoginNotEnoughMoney() {
        String username = this.getRandomString(5);
        String password = "pass1234";

        indexPage
                .run(new RegisterScenario(
                        "test1",
                        "test1",
                        "test1",
                        "test1",
                        "test1",
                        "0000",
                        "11",
                        username,
                        password,
                        password
                ))
                .logout()
                .run(new LoginScenario(username, password))
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
