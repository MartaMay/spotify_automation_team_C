package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Playlist extends TestBase{

    @Test
    public void creatingPlaylist() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        new LoginPage().getLoginButton().click();
        new LoginPage().login();
        Thread.sleep(1000);

        Driver.getDriver().findElement(By.xpath("//button[@aria-label='Create playlist or folder']")).click();
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.className("mWj8N7D_OlsbDgtQx5GW")).click();
        Thread.sleep(2000);



        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//span[text()='Playlists']")).isDisplayed());
    }








}
