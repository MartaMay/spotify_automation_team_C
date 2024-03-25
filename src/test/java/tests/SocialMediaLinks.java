package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.ArrayList;

public class SocialMediaLinks extends TestBase {

    @Test
    public void socialMediaLinks() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("url"));

        logger.info("Log in and navigate to the homepage");
        new LoginPage().getLoginButton().click();
        new LoginPage().login("testuser1@example.com", "\"oB1/@kkPD\"");

        logger.info("Scroll down using the keyboard");
        Thread.sleep(1000);
        new Actions(Driver.getDriver()).sendKeys(Keys.PAGE_DOWN).perform();

        logger.info("Locate Instagram link");
        Driver.getDriver().findElement(By.xpath("//a[@title='Instagram']")).click();

        logger.info("Verify that Spotify’s official Instagram page is displayed");
        SeleniumUtils.switchToWindow();
        Assert.assertEquals(Driver.getDriver().getTitle(), "Spotify (@spotify) • Instagram photos and videos");
        SeleniumUtils.switchToOriginal();

        logger.info("Locate Facebook link");
        Driver.getDriver().findElement(By.xpath("//a[@title='Facebook']")).click();
        SeleniumUtils.switchToWindow();

        logger.info("Verify that Spotify’s official Facebook page is displayed");
        Thread.sleep(1000);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Spotify | Facebook");
        SeleniumUtils.switchToOriginal();

        logger.info("Locate Twitter link");
        Driver.getDriver().findElement(By.xpath("//a[@title='Twitter']")).click();
        SeleniumUtils.switchToWindow();

        logger.info("Verify that Spotify’s official Twitter page is displayed");
        Thread.sleep(1000);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Spotify (@Spotify) / X");
        SeleniumUtils.switchToOriginal();

        logger.info("Navigate back to the homepage");
        Assert.assertEquals(Driver.getDriver().getTitle(), "Spotify - Web Player: Music for everyone");

    }
}
