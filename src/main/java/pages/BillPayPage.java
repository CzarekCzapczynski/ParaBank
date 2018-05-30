package pages;

import assertions.BillPayAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

public class BillPayPage extends LoggedInPage{
    public BillPayAssertion billPayAssertion;

    public BillPayPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
        billPayAssertion = new BillPayAssertion(driver, context);
    }
}
