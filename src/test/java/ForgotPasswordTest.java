import org.testng.annotations.Test;
import scenarios.ForgotPasswordScenario;
import scenarios.RegisterScenario;

public class ForgotPasswordTest extends MainTest{

    @Test
    public void shouldFindCustomer() {
        String username = "zagubionyOgor1";
        String password = "pass1234";
        String firstName = "Ogórek";
        String lastName = "Szklarniowy";
        String street = "Ogórkowa";
        String city = "Grządki";
        String state = "Pole";
        String zipCode = "0000";
        String ssn = "11";

        indexPage.run(new RegisterScenario(
                firstName,
                lastName,
                street,
                city,
                state,
                zipCode,
                ssn,
                username,
                password,
                password))
                .logout()
                .run(new ForgotPasswordScenario(
                firstName,
                lastName,
                street,
                city,
                state,
                zipCode,
                ssn))
                .lookupAssertion.isLoginLocated();
    }
}
