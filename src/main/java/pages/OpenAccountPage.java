package pages;

import assertions.OpenAccountAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;


public class OpenAccountPage extends LoggedInPage {
    public OpenAccountAssertion openAccountAssertion;

    @FindBy(css = "[value='Open New Account']")
    private WebElement openNewAccountButton;

    @FindBy(css = "#type")
    private WebElement accountType;

    @FindBy(css = "#fromAccountId")
    private WebElement fromAccountId;

    public OpenAccountPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
        openAccountAssertion = new OpenAccountAssertion(driver, context);
    }

    public OpenAccountPage clickOpenNewAccountButton() {
        openNewAccountButton.click();
        waitForJStoLoad();
        return this;
    }

    public OpenAccountPage setAccountType(String accountType) {
        Select accountTypeSelect = new Select(this.accountType);
        accountTypeSelect.selectByValue(accountType);
        return this;
    }

    public OpenAccountPage setFromAccountNumberByKey(String fromAccountKey) {
        Select fromAccountSelect = new Select(this.fromAccountId);
        fromAccountSelect.selectByValue(getContextAttribute(fromAccountKey));
        return this;
    }
}
