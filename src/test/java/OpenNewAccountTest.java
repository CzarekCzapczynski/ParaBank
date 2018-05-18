import org.testng.annotations.Test;
import scenarios.LoginScenario;
import scenarios.RegisterScenario;

public class OpenNewAccountTest extends MainTest{

    @Test
    public void shouldOpenAccount(){
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
                .leftMenu.clickOpenNewAccountLink();
    }

}
