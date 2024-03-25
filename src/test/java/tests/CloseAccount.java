package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.ProfilePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

public class CloseAccount extends TestBase{

    @Test
    public void changeLanguage() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));

        logger.info("Log in to Spotify");
        new LoginPage().getLoginButton().click();
        new LoginPage().login("testuser1@example.com", "\"oB1/@kkPD\"");

        logger.info("Navigate to Account Settings");
        new ProfilePage().clickProfile();
        new AccountPage().clickAccount();

        logger.info("Click on close account option and provide confirmation");
        SeleniumUtils.switchToWindow();
        new Actions(Driver.getDriver()).moveToElement(Driver.getDriver().findElement(By.xpath("//a[@data-testid='menu-item-closeAccount']"))).sendKeys(Keys.PAGE_DOWN).perform();
        Driver.getDriver().findElement(By.xpath("//a[@data-testid='menu-item-closeAccount']")).click();
        Driver.getDriver().findElement(By.xpath("//span[text()='Continue to close your account']")).click();
        Driver.getDriver().findElement(By.xpath("//span[@class='Indicator-sc-1airx73-0 klYYtn']")).click();
        Driver.getDriver().findElement(By.xpath("//span[text()='Continue to close your account']")).click();

        logger.info("Account Closure Confirmation");
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//span[text()='Close your account']")).isDisplayed());

    }
}
