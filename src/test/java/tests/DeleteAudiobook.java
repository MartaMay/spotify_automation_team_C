package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AudiobooksPage;
import pages.LoginPage;
import pages.PopUpWindow;
import pages.SearchPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

public class DeleteAudiobook extends TestBase{


    @Test
    public void deleteAudiobook() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        new LoginPage().getLoginButton().click();
        new LoginPage().login();
        new SearchPage().clickSearch();
        new PopUpWindow().closePopUp();
        new AudiobooksPage().clickAudiobooks();

        Driver.getDriver().findElement(By.xpath("//div[@id='Desktop_LeftSidebar_Id']//div[@class='EZFyDnuQnx5hw78phLqP hjb8tUL3rpUa0ez4ZtAj']//header[@class='UvXqRORKQr_N3jlgGTcS']")).click();
        Driver.getDriver().findElement(By.xpath("//span[text()='Audiobooks']")).click();

       try {
           Driver.getDriver().findElement(By.xpath("//div[@class='RowButton-sc-xxkq4e-0 hIehTT']")).click();
           Driver.getDriver().findElement(By.xpath("//button[@class='Button-sc-1dqy6lx-0 iTEdQr']")).click();
           Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//button[@class='Button-sc-1dqy6lx-0 dAlRsJ'][@aria-label='Save to Your Library']")).isDisplayed());

       }catch (NoSuchElementException e){
           System.out.println("You currently don't have any audiobooks in your library: " + e.getMessage());
       }
    }
}
