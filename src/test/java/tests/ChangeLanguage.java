package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;
import utilities.ConfigReader;
import utilities.Driver;

public class ChangeLanguage extends TestBase{

    @Test (groups = "smoke")
    public void changeLanguage(){

        Driver.getDriver().get(ConfigReader.getProperty("url"));

        logger.info("Log in to Spotify");
        new LoginPage().getLoginButton().click();
        new LoginPage().login("testuser1@example.com", "\"oB1/@kkPD\"");

        logger.info("Navigate to settings");
        new ProfilePage().clickProfile();
        Driver.getDriver().findElement(By.xpath("//span[text()='Settings']")).click();

        logger.info("Select language option and choose preferred language");
        new Select(Driver.getDriver().findElement(By.cssSelector(".zrvvPyoxE6wQNqnu0yWA"))).selectByVisibleText("Українська (Ukrainian)");

        logger.info("Apply language changes");
        Driver.getDriver().findElement(By.xpath("//button[text()='Reload']")).click();

        logger.info("Assert that the displayed text matches the expected text in the new language");
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//h1[text()='Налаштування']")).getText(), "Налаштування");
    }

}
