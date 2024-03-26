package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.ExtendLibraryPage;
import pages.LoginPage;
import pages.RecentsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

public class SortByCustomOrder extends TestBase{

    @Test
    public void sortPlayListByCustomOrder() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        new LoginPage().getLoginButton().click();
        new LoginPage().login();

        Thread.sleep(1000);

        SeleniumUtils.jsClick(new ExtendLibraryPage().getExtendLibrary());
        SeleniumUtils.jsClick(Driver.getDriver().findElement(By.xpath("//div[@class='wBsWS202aGdsul2kEGUf']//span[text()='Playlists']")));
        new RecentsPage().clickRecentsPage();

        Driver.getDriver().findElement(By.cssSelector("button[class='mWj8N7D_OlsbDgtQx5GW Vz3pFUXmll6fKB5Fc4nd']")).click();
        Driver.getDriver().findElement(By.xpath("//span[@class='Text__TextElement-sc-if376j-0 gYdBJW encore-text-body-small mdvwJxMDgGjicVAZoBAw']")).click();



        SeleniumUtils.scrollToElement(Driver.getDriver().findElement(By.xpath("//div[@class='JUa6JJNj7R_Y3i4P8YUX']//div[@aria-describedby='onClickHintspotify:playlist:1aGj1KVFjf1E3BueSw5e16']")));
        WebElement lastElement = Driver.getDriver().findElement(By.xpath("//div[@aria-describedby='onClickHintspotify:playlist:1aGj1KVFjf1E3BueSw5e16']"));
        WebElement firstElement = Driver.getDriver().findElement(By.xpath("//div[@aria-describedby='onClickHintspotify:collection:tracks']"));

        new Actions(Driver.getDriver()).dragAndDrop(lastElement,firstElement).perform();


    }
}
