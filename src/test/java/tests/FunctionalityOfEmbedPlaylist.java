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

        logger.info("Log in to Spotify");
        new LoginPage().getLoginButton().click();
        new LoginPage().login();
        new SearchPage().clickSearch();

        logger.info("Navigate to Podcasts");
        SeleniumUtils.jsClick(new PodcastsPage().getPodcasts());
        Driver.getDriver().findElement(By.xpath("//div[@class='CardButton-sc-g9vf2u-0 doNNoL']")).click();
        Driver.getDriver().findElement(By.xpath("//div[@class='eSg4ntPU2KQLfpLGXAww']//button[@class='Button-sc-1dqy6lx-0 dAlRsJ']")).click();
        Driver.getDriver().findElement(By.xpath("//span[text()='Share']")).click();

        logger.info("Locate embed option");
        Driver.getDriver().findElement(By.xpath("//span[text()='Embed show']")).click();
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//h1[text()='Embed show']")).getText(), "Embed show");

        logger.info("Change “Embed Show” window size");
        new Select(Driver.getDriver().findElement(By.cssSelector("#ewg-height"))).selectByIndex(1);

        logger.info("Change “Embed Show” window color");
        Driver.getDriver().findElement(By.cssSelector("button[class='mBGUavHPMlD5mfAmiy5g']")).click();

        logger.info("Verify that the “Embed Show” code is displayed");
        Driver.getDriver().findElement(By.xpath("//label[text()='Show code']")).click();
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//pre[contains(text(),'iframe')]")).isDisplayed());

        logger.info("Take a screenshot");
        SeleniumUtils.takeAScreenshot("src/test/java/tests/embedshow.png");


    }
}
