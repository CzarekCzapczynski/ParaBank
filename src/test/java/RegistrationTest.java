import org.testng.annotations.Test;
import pages.RegisterPage;
import scenarios.RegisterScenario;

public class RegistrationTest extends MainTest {

    @Test
    public void shouldRegister() {
        String password = "pass1234";

        indexPage.run(new RegisterScenario(
                "Ogórek",
                "Szklarniowy",
                "Ogórkowa",
                "Grządki",
                "Pole",
                "0000",
                "11",
                "ogor2",
                password,
                password))
                .registrationAssertion.isUserRegister();
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
                .logout()
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
                .registrationAssertion.isErrorDisplayed("This username already exists.");
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
                .registrationAssertion.isErrorDisplayed("Passwords did not match.");
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
                .registrationAssertion.isErrorDisplayed("Username is required.");
    }
}
