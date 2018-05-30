package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import pages.MainPage;

public class RequestLoanLinkAssertion extends MainPage{
    public RequestLoanLinkAssertion(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
    }
}
