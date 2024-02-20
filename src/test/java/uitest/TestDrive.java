package uitest;

import org.helper.DriverFactory;
import org.helper.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TestDrive {
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

}

