
import org.testng.annotations.Test;

public class ForgotPasswordTest extends MainTest{

    @Test
    public void shouldFindCustomer() {
        indexPage.openIndexPage()
                .clickForgotLoginInfoLink()
                .setFirstName("Ogórek")
                .setLastName("Szklarniowy")
                .setStreet("Ogórkowa")
                .setCity("Grządki")
                .setState("Pole")
                .setZipCode("0000")
                .setSsn("11")
                .clickFindMyLoginInfoButton()
                .lookupAssertion.isLoginLocated();
    }
}
