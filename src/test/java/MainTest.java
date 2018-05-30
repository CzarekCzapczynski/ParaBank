import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.IndexPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

public class MainTest {
    WebDriver driver;
    IndexPage indexPage;
    protected ITestContext context;

    @BeforeMethod
    @Parameters({"url"})
    public void before(ITestContext context, String url){
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        capabilities.setCapability("version", "65");
//        capabilities.setCapability("platform", "WINDOWS");
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.0.34:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        indexPage = new IndexPage(driver, context, url);
        this.context = context;
    }

    @AfterMethod
    public void after(){
        driver.close();
    }

    public static String getRandomString(int length)
    {
        String randomStr = UUID.randomUUID().toString();
        while(randomStr.length() < length) {
            randomStr += UUID.randomUUID().toString();
        }
        return randomStr.substring(0, length);
    }
}
