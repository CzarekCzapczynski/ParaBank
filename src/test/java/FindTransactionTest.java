import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.FindTransactionPage;
import scenarios.AddAccountScenario;
import scenarios.LoginScenario;
import scenarios.RegisterScenario;
import scenarios.TransferFundsScenario;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FindTransactionTest extends MainTest{
    private final String ACCOUNT_TYPE = "SAVINGS";
    private final String ACCOUNT_KEY_TO = "accountKeyNumberTo";
    private final String ACCOUNT_KEY_FROM = "accountKeyNumberFrom";

    private FindTransactionPage start;
    private String login = getRandomString(5);
    private Date today = new Date();
    private DateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

    @BeforeClass
    @Parameters({"password", "url"})
    public void beforeClass(String password, String url){
        before(context, url);
        indexPage
                .run(new RegisterScenario(
                        "test",
                        "test",
                        "test",
                        "test",
                        "test",
                        "0000",
                        "11",
                        login,
                        password,
                        password))
                .leftMenu.clickLogOutLink();
        after();
    }

    @BeforeMethod
    @Parameters({"password"})
    public void beforeTest(String password) {
        start = indexPage.run(new LoginScenario(login, password))
                .leftMenu.clickAccountsOverviewLink()
                .run(new AddAccountScenario(ACCOUNT_TYPE, ACCOUNT_KEY_TO))
                .leftMenu.clickAccountsOverviewLink()
                .run(new TransferFundsScenario("10", ACCOUNT_KEY_FROM, ACCOUNT_KEY_TO))
                .leftMenu.clickFindTransactionLink();
    }

    @Test
    public void shouldFindTransactionByDate(){
        start
            .setFindByDateInput(sdf.format(today))
            .clickDateFindTransactionButton()
            .isTransactionFound();
    }

    @Test
    public void shouldFindTransactionByDateRange() {
        start
                .setFindByDateRangeFromInput(sdf.format(today))
                .setFindByDateRangeToInput(sdf.format(today))
                .clickDateRangeFindTransactionButton()
                .isTransactionFound();
    }

    @Test
    public void shouldFindTransactionByAmount() {
        start
                .setFindByAmountInput("10")
                .clickFindByAmountButton()
                .isTransactionFound();
    }
}
