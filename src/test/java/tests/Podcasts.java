package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PodcastsPage;
import pages.SearchPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.List;

public class Podcasts extends TestBase{


    @Test
    public void podcastCategories() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        new LoginPage().getLoginButton().click();
        new LoginPage().login();

        new SearchPage().clickSearch();

        try {
            SeleniumUtils.waitForVisibility(Driver.getDriver().findElement(By.xpath("//div[@class='Popover__StyledPopover-sc-1iog353-0 hUICWc encore-announcement-set cKHK53VIATgkMZYQDfol']")), 5);
            Driver.getDriver().findElement(By.cssSelector("button[class='Button-sc-1dqy6lx-0 emaScS QMGfkFWtxrVkgNgFXDyw']")).click();

        }catch (NoSuchElementException ignored){
        }

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
