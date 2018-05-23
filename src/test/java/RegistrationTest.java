import org.testng.annotations.Test;
import scenarios.RegisterScenario;

public class RegistrationTest extends MainTest {

    @Test
    public void shouldRegister() {
        String username = getRandomString(5);
        String password = "pass1234";

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
    public void shouldNotRegisterUserExists() {
        String password = "pass1234";

        indexPage.run(new RegisterScenario(
                "Ogórek",
                "Szklarniowy",
                "Ogórkowa",
                "Grządki",
                "Pole",
                "0000",
                "11",
                "ogor23",
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
                "ogor23",
                password,
                password))
                .registerAssertion.isErrorDisplayed("This username already exists.");
    }

    @Test
    public void shouldNotRegisterPasswordsDidNotMatch() {
        String password = "pass1234";

        indexPage.run(new RegisterScenario(
                "Ogórek",
                "Szklarniowy",
                "Ogórkowa",
                "Grządki",
                "Pole",
                "0000",
                "11",
                "ogor3",
                password ,
                password + "a"))
                .registerAssertion.isErrorDisplayed("Passwords did not match.");
    }

    @Test
    public void shouldNotRegisterRequiredUsername() {
        String password = "pass1234";

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
