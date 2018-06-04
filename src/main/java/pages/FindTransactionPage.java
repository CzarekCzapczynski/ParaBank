package pages;

import assertions.FindTransactionAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

public class FindTransactionPage extends LoggedInPage{
    public FindTransactionAssertion findTransactionAssertion;

    @FindBy(css = "#accountId")
    private WebElement accountIdSelect;

    @FindBy(css = "[id*='transactionId']")
    private WebElement findByTransactionIdInput;

    @FindBy(css = "[value='ID']")
    private WebElement idFindTransactionButton;

    @FindBy(css = "[id*='onDate']")
    private WebElement findByDateInput;

    @FindBy(css = "[value='DATE']")
    private WebElement dateFindTransactionButton;

    @FindBy(css = "[id*='fromDate']")
    private WebElement findByDateRangeFromInput;

    @FindBy(css = "[id*='toDate']")
    private WebElement findByDateRangeToInput;

    @FindBy(css = "[value='DATE_RANGE']")
    private WebElement dateRangeFindTransactionButton;

    @FindBy(css = "[id*='amount']")
    private WebElement findByAmountInput;

    @FindBy(css = "[value='AMOUNT']")
    private WebElement findByAmountButton;

    public FindTransactionPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
        findTransactionAssertion = new FindTransactionAssertion(driver, context);
    }

    public FindTransactionPage setFindByDateInput(String findByDateInput) {
        this.findByDateInput.sendKeys(findByDateInput);
        return this;
    }

    public FindTransactionAssertion clickDateFindTransactionButton() {
        this.dateFindTransactionButton.click();
        return new FindTransactionAssertion(driver, getContext());
    }

    public FindTransactionPage setFindByDateRangeFromInput(String findByDateRangeFromInput) {
        this.findByDateRangeFromInput.sendKeys(findByDateRangeFromInput);
        return this;
    }

    public FindTransactionPage setFindByDateRangeToInput(String findByDateRangeToInput) {
        this.findByDateRangeToInput.sendKeys(findByDateRangeToInput);
        return this;
    }

    public FindTransactionAssertion clickDateRangeFindTransactionButton() {
        this.dateRangeFindTransactionButton.click();
        return new FindTransactionAssertion(driver, getContext());
    }

    public FindTransactionPage setFindByAmountInput(String findByAmountInput) {
        this.findByAmountInput.sendKeys(findByAmountInput);
        return this;
    }

    public FindTransactionAssertion clickFindByAmountButton() {
        this.findByAmountButton.click();
        return new FindTransactionAssertion(driver, getContext());
    }
}
