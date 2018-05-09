import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AccountPage;
import pages.IndexPage;

public class MainTest {
    WebDriver driver;
    IndexPage indexPage;
    AccountPage accountPage;


    @BeforeMethod
    public void before(){
        driver = new ChromeDriver();
        indexPage = new IndexPage(driver);
        accountPage = new AccountPage(driver);
    }

    @AfterMethod
    public void after(){
        driver.close();
    }
}
