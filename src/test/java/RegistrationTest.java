import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import scenarios.RegisterScenario;

public class RegistrationTest extends MainTest {

    @BeforeClass
    @Parameters({"url"})
    public void beforeClass(String url){
        before(context, url);
        after();
    }

    @Test
    @Parameters({"password"})
    public void shouldRegister(String password) {
        String username = getRandomString(5);

        indexPage.run(new RegisterScenario(
                "Ogórek",
                "Szklarniowy",
                "Ogórkowa",
                "Grządki",
                "Pole",
                "0000",
                "11",
                username,
                password,
                password))
                .registerAssertion.isUserRegister();
    }

    @Test
    @Parameters({"password"})
    public void shouldNotRegisterUserExists(String password) {
        String username = getRandomString(5);

        indexPage.run(new RegisterScenario(
                "Ogórek",
                "Szklarniowy",
                "Ogórkowa",
                "Grządki",
                "Pole",
                "0000",
                "11",
                username,
                password,
                password))
                .leftMenu.clickLogOutLink()
                .run(new RegisterScenario(
                "Ogórek",
                "Szklarniowy",
                "Ogórkowa",
                "Grządki",
                "Pole",
                "0000",
                "11",
                username,
                password,
                password))
                .registerAssertion.isErrorDisplayed("This username already exists.");
    }

    @Test
    @Parameters("password")
    public void shouldNotRegisterPasswordsDidNotMatch(String password) {
        String username = getRandomString(5);

        indexPage.run(new RegisterScenario(
                "Ogórek",
                "Szklarniowy",
                "Ogórkowa",
                "Grządki",
                "Pole",
                "0000",
                "11",
                username,
                password,
                password + "a"))
                .registerAssertion.isErrorDisplayed("Passwords did not match.");
    }

    @Test
    @Parameters("password")
    public void shouldNotRegisterRequiredUsername(String password) {

        indexPage.run(new RegisterScenario(
                "Ogórek",
                "Szklarniowy",
                "Ogórkowa",
                "Grządki",
                "Pole",
                "0000",
                "11",
                "",
                password,
                password))
                .registerAssertion.isErrorDisplayed("Username is required.");
    }
}
