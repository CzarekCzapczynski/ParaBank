package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.MainPage;

public class TransferAssertion extends MainPage {
    public TransferAssertion(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
