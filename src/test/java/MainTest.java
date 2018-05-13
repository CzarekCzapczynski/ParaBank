import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AccountPage;
import pages.IndexPage;
import pages.MainPage;
import pages.RegisterPage;

public class MainTest {
    WebDriver driver;
    MainPage mainPage;
    IndexPage indexPage;
    AccountPage accountPage;
    RegisterPage registerPage;


    @BeforeMethod
    public void before(){
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        indexPage = new IndexPage(driver);
        accountPage = new AccountPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @AfterMethod
    public void after(){
        driver.close();
    }

}
