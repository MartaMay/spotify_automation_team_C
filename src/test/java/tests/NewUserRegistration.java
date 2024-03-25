package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;
import utilities.CSVReader;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.SeleniumUtils;

public class NewUserRegistration extends TestBase {

    @Test (dataProvider = "loginData")
    public void newUserSignUp(String email, String password, String name, String day, String year) throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("url"));

        logger.info("Navigate to the Registration Page");
        Driver.getDriver().findElement(By.xpath("//button[text()='Sign up']")).click();
        logger.info("Provide registration credentials (username, email, password etc) from the data provider");
        Driver.getDriver().findElement(By.id("username")).sendKeys(email);
        Driver.getDriver().findElement(By.xpath("//span[text()='Next']")).click();
        Driver.getDriver().findElement(By.id("new-password")).sendKeys(password);
        Thread.sleep(1000);
        SeleniumUtils.jsClick(Driver.getDriver().findElement(By.xpath("//span[text()='Next']")));
        Driver.getDriver().findElement(By.xpath("(//input[@class='Input-sc-1gbx9xe-0 zFmyO'])[3]")).sendKeys(name);

        Select select = new Select(Driver.getDriver().findElement(By.id("month")));
        select.selectByVisibleText("March");
        Driver.getDriver().findElement(By.id("day")).sendKeys(day);
        Driver.getDriver().findElement(By.id("year")).sendKeys(year);
        Driver.getDriver().findElement(By.xpath("//label[@for='gender_option_prefer_not_to_say']")).click();
        Driver.getDriver().findElement(By.xpath("//span[text()='Next']")).click();
        Driver.getDriver().findElement(By.xpath("//span[text()='Sign up']")).click();
        logger.info("Log in with the registered credentials");
        new ProfilePage().clickProfile();
        Driver.getDriver().findElement(By.xpath("//span[text()='Profile']")).click();

        logger.info("Confirm that profile name matching the name entered on registration page");
        Assert.assertEquals(name, Driver.getDriver().findElement(By.xpath("//h1[@class='Text__TextElement-sc-if376j-0 ksSRyh encore-text-headline-large']")).getText());






    }

    @DataProvider (name = "loginData")
    public Object[][] getData(){

        Object[][] data = CSVReader.readData("src/test/resources/login_data.csv");
        return  data;
    }

}
