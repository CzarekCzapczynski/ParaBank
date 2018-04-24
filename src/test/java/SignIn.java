import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignIn {
    WebDriver driver = new ChromeDriver();

    public void login (String userName, String password) {
        driver.findElement(By.cssSelector("[name='username']")).sendKeys(userName);
        driver.findElement(By.cssSelector("[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("div .login .button")).click();
    }


}
