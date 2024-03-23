package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PodcastsPage;
import pages.PopUpWindow;
import pages.SearchPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

public class UnsubscribeFromPodcast extends TestBase {


    @Test (groups = "smoke")
    public void unsubscribeFromPodcast() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        new LoginPage().getLoginButton().click();
        new LoginPage().login();

        new SearchPage().clickSearch();
        Driver.getDriver().navigate().refresh();
        Thread.sleep(1000);
        new PopUpWindow().closePopUp();

        Driver.getDriver().findElement(By.xpath("//div[@id='Desktop_LeftSidebar_Id']//div[@class='EZFyDnuQnx5hw78phLqP hjb8tUL3rpUa0ez4ZtAj']//header[@class='UvXqRORKQr_N3jlgGTcS']")).click();

        try {
            Driver.getDriver().findElement(By.xpath("//span[text()='Podcasts & Shows']")).click();
            Driver.getDriver().findElement(By.xpath("(//div[@class='JUa6JJNj7R_Y3i4P8YUX']//li[@class='NxEINIJHGytq4gF1r2N1  qEiVyQ28VnOKb0LeijqL'])[1]")).click();

            Driver.getDriver().findElement(By.xpath("//button[text()='Following']")).click();
            Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//button[text()='Follow']")).isDisplayed());
        } catch (NoSuchElementException e) {

            System.out.println("You currently don't have any subscriptions: " + e.getMessage());
            Driver.getDriver().quit();
        }



    }
}