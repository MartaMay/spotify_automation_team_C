package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.io.File;
import java.io.IOException;

public class FunctionalityOfEmbedPlaylist extends TestBase{

    @Test
    public void embedPlaylist() throws IOException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        new LoginPage().getLoginButton().click();
        new LoginPage().login("testuser1@example.com", "\"oB1/@kkPD\"");
        new SearchPage().clickSearch();
        //navigate to Podcasts
        SeleniumUtils.jsClick(new PodcastsPage().getPodcasts());
        Driver.getDriver().findElement(By.xpath("//div[@class='CardButton-sc-g9vf2u-0 doNNoL']")).click();
        Driver.getDriver().findElement(By.xpath("//div[@class='eSg4ntPU2KQLfpLGXAww']//button[@class='Button-sc-1dqy6lx-0 dAlRsJ']")).click();
        Driver.getDriver().findElement(By.xpath("//span[text()='Share']")).click();
        //locate embed playlist
        Driver.getDriver().findElement(By.xpath("//span[text()='Embed show']")).click();

        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//h1[text()='Embed show']")).getText(), "Embed show");

        //change size of the playlist
        new Select(Driver.getDriver().findElement(By.cssSelector("#ewg-height"))).selectByIndex(1);

        //change color
        Driver.getDriver().findElement(By.cssSelector("button[class='mBGUavHPMlD5mfAmiy5g']")).click();

        //show the code of iframe
        Driver.getDriver().findElement(By.xpath("//label[text()='Show code']")).click();
        //confirm that the code is displayed

        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//pre[contains(text(),'iframe')]")).isDisplayed());

        //take a screenshot

        SeleniumUtils.takeAScreenshot("src/test/java/tests/embedshow.png");

        new ProfilePage().clickProfile();
        new LogOut().clickLogOut();




    }
}
