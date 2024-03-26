package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ExtendLibraryPage;
import pages.LoginPage;
import pages.RecentsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortAudiobooksAlphabetical extends TestBase{

    @Test
    public void sortAudiobooksAlphabetical() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        new LoginPage().getLoginButton().click();
        new LoginPage().login();

        SeleniumUtils.jsClick(new ExtendLibraryPage().getExtendLibrary());
        Driver.getDriver().findElement(By.xpath("//div[@class='wBsWS202aGdsul2kEGUf']//span[text()='Audiobooks']")).click();
        new RecentsPage().clickRecentsPage();
        Driver.getDriver().findElement(By.xpath("//li[@class='rQ6LXqVlEOGZdGIG0LgP']//span[text()='Alphabetical']")).click();
        new RecentsPage().clickRecentsPage();

        Thread.sleep(2000);

        List<WebElement> songsList = Driver.getDriver().findElements(By.xpath("//span[@class='ListRowTitle__LineClamp-sc-1xe2if1-0 jjpOuK']"));

        List<String> actualSongs = new ArrayList<>();

        for(WebElement song : songsList) {
            actualSongs.add(song.getText());
        }
        for (String actualSong : actualSongs) {
            System.out.println(actualSong);
        }
        System.out.println("------------------------------------");

        List<String> modifiedSongs = new ArrayList<>();
        for (String song : actualSongs) {
            modifiedSongs.add(song.replaceAll("^The ", "").replaceAll("A ", ""));
        }

        Collections.sort(modifiedSongs);
        for (String modifiedSong : modifiedSongs) {
            System.out.println(modifiedSong);
        }

        Assert.assertEquals(actualSongs, modifiedSongs);
    }
}
