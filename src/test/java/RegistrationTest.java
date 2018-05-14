import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegistrationTest extends MainTest {

    @Test
    public void shouldRegister() {
        String password = "pass1234";

        registerPage.openRegisterPage()
                .setFirstName("Ogórek")
                .setLastName("Szklarniowy")
                .setStreet("Ogórkowa")
                .setCity("Grządki")
                .setState("Pole")
                .setZipCode("0000")
                .setSsn("11")
                .setUsername("ogor1165")
                .setPassword(password)
                .setRepeatedPassword(password)
                .clickRegisterButton()
                .registrationAssertion.isUserRegister();
    }

    @Test
    public void shouldNotRegisterUserExists() {
        String password = "pass1234";
        RegisterPage register = new RegisterPage(driver);

        for (int i=1; i<=3; i++) {
            register = registerPage.openRegisterPage()
                    .fillRegisterForm("Ogórek", "Szklarniowy",
                            "Ogórkowa", "Grządki", "Pole", "0000",
                            "11", "ogor2", password ,password)
                    .clickRegisterButton();
        }
        register.registrationAssertion.isErrorDisplayed("This username already exists.");
    }

    @Test
    public void shouldNotRegisterPasswordsDidNotMatch() {
        String password = "pass1234";

        registerPage.openRegisterPage()
                .fillRegisterForm("Ogórek", "Szklarniowy",
                        "Ogórkowa", "Grządki", "Pole", "0000",
                        "11", "ogor3", password ,password + "a")
                .clickRegisterButton()
                .registrationAssertion.isErrorDisplayed("Passwords did not match.");
    }

    @Test
    public void shouldNotRegisterRequiredUsername() {
        String password = "pass1234";

        registerPage.openRegisterPage()
                .fillRegisterForm("Ogórek", "Szklarniowy",
                        "Ogórkowa", "Grządki", "Pole", "0000",
                        "11", "", password ,password)
                .clickRegisterButton()
                .registrationAssertion.isErrorDisplayed("Username is required.");
    }
}
