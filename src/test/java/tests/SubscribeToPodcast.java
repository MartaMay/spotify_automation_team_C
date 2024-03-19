package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PodcastsPage;
import pages.PopUpWindow;
import pages.SearchPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.List;
import java.util.Random;

public class SubscribeToPodcast extends TestBase {


    @Test
    public void subscribeToPodcast() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        new LoginPage().getLoginButton().click();
        new LoginPage().login();

        new SearchPage().clickSearch();
        new PopUpWindow().closePopUp();
        new PodcastsPage().clickPodcasts();

        Driver.getDriver().findElement(By.linkText("See all categories")).click();
        Driver.getDriver().findElement(By.xpath("//span[text()='Film']")).click();

        Thread.sleep(1000);
        Driver.getDriver().findElement(By.xpath("//div[@class='Box__BoxComponent-sc-y4nds-0 fqjnfn Box-sc-1njtxi4-0 hscyXl aAYpzGljXQv1_zfopxaH XiVwj5uoqqSFpS4cYOC6']")).click();

        Thread.sleep(1000);
        try{
            Driver.getDriver().findElement(By.xpath("//button[text()='Follow']")).click();
        } catch (NoSuchElementException e){
            Driver.getDriver().navigate().back();
            List<WebElement> podcasts = Driver.getDriver().findElements(By.xpath("//div[@class='Box__BoxComponent-sc-y4nds-0 fqjnfn Box-sc-1njtxi4-0 hscyXl aAYpzGljXQv1_zfopxaH XiVwj5uoqqSFpS4cYOC6']"));
            podcasts.get(new Random().nextInt(podcasts.size())).click();
            Driver.getDriver().findElement(By.xpath("//button[text()='Follow']")).click();

        }
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//button[text()='Following']")).isDisplayed());
    }
}