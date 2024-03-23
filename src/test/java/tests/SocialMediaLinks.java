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
        new LoginPage().getLoginButton().click();
        new LoginPage().login("testuser1@example.com", "\"oB1/@kkPD\"");
        System.out.println(Driver.getDriver().getTitle());
//scroll down to social media. open instagram
        Thread.sleep(1000);
        SeleniumUtils.scrollToElement(Driver.getDriver().findElement(By.xpath("//a[@title='Instagram']")));
        Driver.getDriver().findElement(By.xpath("//a[@title='Instagram']")).click();

        SeleniumUtils.switchToWindow();
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://www.instagram.com/spotify/");

       SeleniumUtils.switchToOriginal();
// open facebook
        Driver.getDriver().findElement(By.xpath("//a[@title='Facebook']")).click();
        SeleniumUtils.switchToWindow();
        System.out.println(Driver.getDriver().getTitle());
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.facebook.com/Spotify");

        SeleniumUtils.switchToOriginal();
        Thread.sleep(1000);
    // open twitter
        Driver.getDriver().findElement(By.xpath("//a[@title='Twitter']")).click();
        SeleniumUtils.switchToWindow();
        System.out.println(Driver.getDriver().getTitle());
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://twitter.com/spotify");

        SeleniumUtils.switchToOriginal();






    }
}
