import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LookupPage;

public class ForgotPasswordTest {
    WebDriver driver;
    LookupPage lookupPage;
    AccountPage accountPage;

    @BeforeMethod
    public void before(){
        driver = new ChromeDriver();
        lookupPage = new LookupPage(driver);
        accountPage = new AccountPage(driver);
    }

    @Test
    public void shouldFindCustomer() {
        lookupPage.openLookupPage();
        lookupPage.waitForJStoLoad();
        lookupPage.fillLookupForm("Ogórek", "Szklarniowy",
                "Ogórkowa", "Grządki", "Pole", "0000", "11");
        lookupPage.clickFindMyLoginInfoButton();
        lookupPage.waitForJStoLoad();
        Assert.assertTrue(lookupPage.isExecutionPassed(By.cssSelector("a[href$='logout.htm']")));
    }
}
