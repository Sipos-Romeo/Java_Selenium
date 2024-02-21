package uitest;

import org.helper.DriverFactory;
import org.helper.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginTests {
    //Test that shows
    @Test
    public void LoginTest() throws InterruptedException {
        WebDriver driver = DriverFactory.CreateDriver();

        driver.get(Pages.LogInPage);


        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.id("login-button"));


        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        login.click();

        Assert.assertEquals(driver.getCurrentUrl(), Pages.MainPage);

        WebElement products = driver.findElement(By.className("product_label"));
        Assert.assertTrue(products.isDisplayed());


        Thread.sleep(5000);

        driver.quit();
    }
   @Test
    public void LogInWrongCredentials() throws InterruptedException {
        WebDriver driver = DriverFactory.CreateDriver();

        driver.get(Pages.LogInPage);

        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.id("login-button"));

        username.sendKeys("Abraham");
        password.sendKeys("Lincoln");
        login.click();

        Assert.assertEquals(driver.getCurrentUrl(), Pages.LogInPage);
        WebElement Swaglabs = driver.findElement(By.className("login_logo"));
        WebElement error = driver.findElement(By.className("error-button"));

        Assert.assertTrue(Swaglabs.isDisplayed());
        Assert.assertTrue(error.isDisplayed());

        Thread.sleep(5000);

        driver.quit();
    }
    @Test
    public void LogInPhoto() throws InterruptedException {
        WebDriver driver = DriverFactory.CreateDriver();

        driver.get(Pages.LogInPage);

        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.id("login-button"));

        username.sendKeys("locked_out_user");
        password.sendKeys("secret_sauce");
        login.click();


        WebElement Swaglabs = driver.findElement(By.className("login_logo"));
        WebElement icon = driver.findElement(By.className("bot_column"));

        Assert.assertTrue(Swaglabs.isDisplayed());
        Assert.assertTrue(icon.isDisplayed());


        driver.quit();
    }

}

