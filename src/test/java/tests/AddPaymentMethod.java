package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.ProfilePage;
import utilities.CSVReader;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.security.Key;

public class AddPaymentMethod extends TestBase {

    @Test (dataProvider = "cardnumber")
    public void addPaymentMethod(String cardNumber, String expDate, String secCode) {

        Driver.getDriver().get(ConfigReader.getProperty("url"));

        logger.info("Login existing to Spotify account");
        new LoginPage().getLoginButton().click();
        new LoginPage().login();

        logger.info("Navigate to Account Page");
        new ProfilePage().clickProfile();
        new AccountPage().clickAccount();

        logger.info("Open Saved Payment Card window");
        SeleniumUtils.switchToWindow();
        SeleniumUtils.jsClick(Driver.getDriver().findElement(By.xpath("//div[@id='onClickHintsavedPaymentCards']")));
        Driver.getDriver().findElement(By.xpath("//button[@class='Button-sc-1dqy6lx-0 cEdLhZ']")).click();

        logger.info("Add card details");
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@src='https://pci.spotify.com/static/form_no_selects.html']")));
        Driver.getDriver().findElement(By.xpath("//div[@class='input-form-group']//input[@id='cardnumber']"))
                .sendKeys(cardNumber, Keys.TAB, expDate, Keys.TAB, secCode);

        Driver.getDriver().switchTo().defaultContent();

        logger.info("Save card");
        SeleniumUtils.jsClick(Driver.getDriver().findElement(By.xpath("//span[text()='Save']")));



    }

    @DataProvider(name = "cardnumber")
    public Object[][] getData(){

        Object[][] data = CSVReader.readData("src/test/resources/creditcards.csv");
        return  data;
    }
}
