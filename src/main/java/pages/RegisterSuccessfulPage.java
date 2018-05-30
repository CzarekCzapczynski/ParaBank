package pages;

import assertions.RegistrationAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

public class RegisterSuccessfulPage extends LoggedInPage{

    public RegistrationAssertion registerAssertion;

    public RegisterSuccessfulPage(WebDriver driver, ITestContext context){
        super(driver, context);
        PageFactory.initElements(driver, this);
        registerAssertion = new RegistrationAssertion(driver, context);
    }

}
