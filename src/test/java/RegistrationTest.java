import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.RegisterPage;

public class RegistrationTest extends MainTest {



    private RegisterPage registerPage;

//    public void fillRegisterForm(String firstName, String lastName,
//                              String street, String city, String state, String zipCode,
//                              String ssn,
//                              String username, String password, String repeatedPassword) {
//        setFirstName(firstName);
//        setLastName(lastName);
//        setStreet(street);
//        setCity(city);
//        setState(state);
//        setZipCode(zipCode);
//        setSsn(ssn);
//        setUsername(username);
//        setPassword(password);
//        setRepeatedPassword(repeatedPassword);
//    }

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
                .setUsername("ogor115")
                .setPassword(password)
                .setRepeatedPassword(password)
                .clickRegisterButton()
//                .loginAssertion.IsUserLoggedIn
        ;

//        registerPage.fillRegisterForm(, ,
//                , , , ,
//                , , password ,password);
//        registerPage.clickRegisterButton();
//        registerPage.waitForJStoLoad();
//        Assert.assertTrue(accountPage.isUserLoggedIn());
    }

//    @Test
//    public void shouldNotRegisterUserExist() {
//        String password = "pass1234";
//        String error = "[id='customer.username.errors']";
//
//        for (int i=1; i<=3; i++) {
//            registerPage.openRegisterPage();
//            registerPage.fillRegisterForm("Ogórek", "Szklarniowy",
//                    "Ogórkowa", "Grządki", "Pole", "0000",
//                    "11", "ogor2", password ,password);
//            registerPage.clickRegisterButton();
//        }
//        registerPage.isErrorDuringExecution(By.cssSelector(error));
//    }
//
//    @Test
//    public void shouldNotRegisterDifferentPassword() {
//        String password = "pass1234";
//        String error = "[id='repeatedPassword.errors']";
//
//        registerPage.openRegisterPage();
//        registerPage.fillRegisterForm("Ogórek", "Szklarniowy",
//                "Ogórkowa", "Grządki", "Pole", "0000",
//                "11", "ogor3", password ,password + "a");
//        registerPage.clickRegisterButton();
//        registerPage.isErrorDuringExecution(By.cssSelector(error));
//    }
//
//    @Test
//    public void shouldNotRegisterEmptyUsername() {
//        String password = "pass1234";
//        String error = "[id='customer.username.errors']";
//
//        registerPage.openRegisterPage();
//        registerPage.fillRegisterForm("Ogórek", "Szklarniowy",
//                "Ogórkowa", "Grządki", "Pole", "0000",
//                "11", "", password ,password);
//        registerPage.clickRegisterButton();
//        registerPage.isErrorDuringExecution(By.cssSelector(error));
//    }
}
