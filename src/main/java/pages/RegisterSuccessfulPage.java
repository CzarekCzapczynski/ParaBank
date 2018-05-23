package pages;

import assertions.RegistrationAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegisterSuccessfulPage extends LoggedInPage{

    public RegistrationAssertion registerAssertion;

    public RegisterSuccessfulPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        registerAssertion = new RegistrationAssertion(driver);
    }

}
