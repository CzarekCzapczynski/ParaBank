package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import pages.MainPage;

public class TransferAssertion extends MainPage {
    public TransferAssertion(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
    }
}
