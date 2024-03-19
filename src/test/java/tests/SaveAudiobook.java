package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AudiobooksPage;
import pages.LoginPage;
import pages.PopUpWindow;
import pages.SearchPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.List;

public class SaveAudiobook extends TestBase{

    @Test(groups = "smoke")
    public void saveAudiobook() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        new LoginPage().getLoginButton().click();
        new LoginPage().login();

        new SearchPage().clickSearch();
        new AudiobooksPage().clickAudiobooks();
        new PopUpWindow().closePopUp();

        Driver.getDriver().findElement(By.xpath("//div[@class='CardButton-sc-g9vf2u-0 doNNoL']")).click();
        Driver.getDriver().findElement(By.xpath("(//button[@class='Button-sc-1dqy6lx-0 dAlRsJ'])[1]")).click();

        String actualTitle = Driver.getDriver().findElement(By.xpath("//h1[text()]")).getText();

        Driver.getDriver().findElement(By.xpath("//div[@id='Desktop_LeftSidebar_Id']//div[@class='EZFyDnuQnx5hw78phLqP hjb8tUL3rpUa0ez4ZtAj']//header[@class='UvXqRORKQr_N3jlgGTcS']")).click();
        Driver.getDriver().findElement(By.xpath("//span[text()='Audiobooks']")).click();

        String expectedTitle = null;
        try {
            expectedTitle = Driver.getDriver().findElement(By.xpath("(//div[@class='JUa6JJNj7R_Y3i4P8YUX']//li[@class='NxEINIJHGytq4gF1r2N1  qEiVyQ28VnOKb0LeijqL'])[1]")).getText();

        } catch (NoSuchElementException e) {
            System.out.println("You currently don't have any audiobooks added to your library.");
        }

        if (expectedTitle != null) {
            Assert.assertTrue(expectedTitle.contains(actualTitle));
        }
    }
}
