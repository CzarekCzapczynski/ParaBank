import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Initialize {
    WebDriver driver = new ChromeDriver();

    public void InitializeParaBank() {
        driver.get("http://parabank.parasoft.com");
    }

    @Test(priority = 1)
    public void shouldInitializeParaBank() {
        InitializeParaBank();
        Assert.assertTrue(driver.findElement(By.cssSelector("div #topPanel a[href*='index.htm']")).isDisplayed());
    }
}
