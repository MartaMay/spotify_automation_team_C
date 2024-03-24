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
        new LoginPage().getLoginButton().click();
        //login
        new LoginPage().login("testuser1@example.com", "\"oB1/@kkPD\"");

        new ProfilePage().clickProfile();
        new AccountPage().clickAccount();

        SeleniumUtils.switchToWindow();
        new Actions(Driver.getDriver()).moveToElement(Driver.getDriver().findElement(By.xpath("//a[@data-testid='menu-item-closeAccount']"))).sendKeys(Keys.PAGE_DOWN).perform();
        Driver.getDriver().findElement(By.xpath("//a[@data-testid='menu-item-closeAccount']")).click();
        Driver.getDriver().findElement(By.xpath("//span[text()='Continue to close your account']")).click();
        Driver.getDriver().findElement(By.xpath("//span[@class='Indicator-sc-1airx73-0 klYYtn']")).click();
        Driver.getDriver().findElement(By.xpath("//span[text()='Continue to close your account']")).click();

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//span[text()='Close your account']")).isDisplayed());



    }
}
