package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends MainPage{

    @FindBy(css = "[href*='openaccount.htm']")
    private WebElement openNewAccountLink;

    @FindBy(css = "[href*='overview.htm']")
    private WebElement accountsOverviewLink;

    @FindBy(css = "[href*='transfer.htm']")
    private WebElement transferFundsLink;

    @FindBy(css = "[href*='billpay.htm']")
    private WebElement billPayLink;

    @FindBy(css = "[href*='findtrans.htm']")
    private WebElement findTransactionLink;

    @FindBy(css = "[href*='updateprofile.htm']")
    private WebElement updateContactInfoLink;

    @FindBy(css = "[href*='requestloan.htm']")
    private WebElement requestLoanLink;

    @FindBy(css = "[href*='logout.htm']")
    private WebElement logOutLink;

    public MenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AccountPage clickAccountsOverviewLink(){
        accountsOverviewLink.click();
        waitForJStoLoad();
        return new AccountPage(driver);
    }

    public OpenAccountPage clickOpenNewAccountLink() {
        openNewAccountLink.click();
        waitForJStoLoad();
        return new OpenAccountPage(driver);
    }

    public TransferPage clickTransferFundsLink() {
        transferFundsLink.click();
        waitForJStoLoad();
        return new TransferPage(driver);
    }
    public BillPayPage clickBillPayLink() {
        billPayLink.click();
        waitForJStoLoad();
        return new BillPayPage(driver);
    }

    public FindTransactionPage clickfindTransactionLink() {
        findTransactionLink.click();
        waitForJStoLoad();
        return new FindTransactionPage(driver);
    }

    public UpdateContactInfoPage clickUpdateContactInfoLink() {
        updateContactInfoLink.click();
        waitForJStoLoad();
        return new UpdateContactInfoPage(driver);
    }

    public RequestLoanLinkPage clickRequestLoanLink() {
        requestLoanLink.click();
        waitForJStoLoad();
        return new RequestLoanLinkPage(driver);
    }

    public IndexPage clickLogOutLink() {
        logOutLink.click();
        waitForJStoLoad();
        return new IndexPage(driver);
    }
}
