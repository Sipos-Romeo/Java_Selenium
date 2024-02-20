package uitest;

import org.helper.DriverFactory;
import org.helper.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class TestDrive {
    private static final String URL = "https://www.saucedemo.com";
    @Test
    public void test() throws InterruptedException {
        WebDriver driver = DriverFactory.CreateDriver();

        driver.get(Pages.LogInPage);


        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.id("login-button"));


        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        login.click();


        Thread.sleep(5000);

        driver.quit();
    }
}