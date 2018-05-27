package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.MainPage;

public class BillPayAssertion extends MainPage{
    public BillPayAssertion(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
