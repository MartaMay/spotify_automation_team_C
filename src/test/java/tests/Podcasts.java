package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PodcastsPage;
import pages.SearchPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class Podcasts extends TestBase{


    @Test
    public void podcastCategories() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        new LoginPage().getLoginButton().click();
        new LoginPage().login();

        new SearchPage().clickSearch();


        new PodcastsPage().clickPodcasts();

        Driver.getDriver().findElement(By.linkText("See all categories")).click();
        List<WebElement> categories = Driver.getDriver().findElements(By.xpath("//a[@class='jXeqeqkxEBVeFjA2YydA']"));
        Assert.assertEquals(categories.size(), 54);

        Driver.getDriver().findElement(By.xpath("//span[text()='Business']")).click();
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.xpath("//div[@class='CardButton-sc-g9vf2u-0 doNNoL']")).click();
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//span[text()='Business']")).isDisplayed());

    }

}
