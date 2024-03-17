package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PodcastsPage;
import pages.SearchPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

public class SubscribeToPodcast extends TestBase {


    @Test
    public void subscribeToPodcast() throws InterruptedException {
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

        Driver.getDriver().findElement(By.xpath("//span[text()='Film']")).click();
        Driver.getDriver().findElement(By.xpath("//div[@class='Box__BoxComponent-sc-y4nds-0 fqjnfn Box-sc-1njtxi4-0 hscyXl aAYpzGljXQv1_zfopxaH XiVwj5uoqqSFpS4cYOC6']")).click();

        Thread.sleep(1000);
        if (Driver.getDriver().findElement(By.xpath("//button[text()='Follow']")).isDisplayed()) {
            Driver.getDriver().findElement(By.xpath("//button[text()='Follow']")).click();

        }else {
            System.out.println("You already subscribed to this podcast.");
        }
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//button[text()='Following']")).isDisplayed());
    }
}