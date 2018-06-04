import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AccountPage;
import scenarios.AddAccountScenario;
import scenarios.LoginScenario;
import scenarios.RegisterScenario;

import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FindTransactionTest extends MainTest{

    private AccountPage start;
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
        start = indexPage.run(new LoginScenario(login, password));
    }

    @Test
    public void shouldFindTransactionByDate(){

        start
            .leftMenu.clickfindTransactionLink()
            .setFindByDateInput(sdf.format(today))
            .clickDateFindTransactionButton()
            .isTransactionFound();
    }

    @Test
    public void shouldFindTransactionByDateRange() {
        start
                .leftMenu.clickfindTransactionLink()
                .setFindByDateRangeFromInput(sdf.format(today))
                .setFindByDateRangeToInput(sdf.format(today))
                .clickDateRangeFindTransactionButton()
                .isTransactionFound();
    }

    @Test
    public void shouldFindTransactionByAmount() {
        start
                .leftMenu.clickfindTransactionLink()
                .setFindByAmountInput("100")
                .clickFindByAmountButton()
                .isTransactionFound();
    }
}
