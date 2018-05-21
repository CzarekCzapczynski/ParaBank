package pages;

import assertions.OpenAccountAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OpenAccountPage extends LoggedInPage {
    public OpenAccountAssertion openAccountAssertion;

    @FindBy(css = "[value='Open New Account']")
    private WebElement openNewAccountButton;

    @FindBy(css = "#type")
    private WebElement accountType;

    @FindBy(css = "#fromAccountId")
    private WebElement fromAccountId;

    public OpenAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAccountAssertion = new OpenAccountAssertion(driver);
    }

    public OpenAccountPage clickOpenNewAccountButton() {
        openNewAccountButton.click();
        waitForJStoLoad();
        return this;
    }

    public OpenAccountPage setAccountType(String accountType) {
        this.accountType.sendKeys(accountType);
        return this;
    }

    public OpenAccountPage setFromAccountId(String fromAccount) {
        fromAccountId.sendKeys(fromAccount);
        return this;
    }
}
