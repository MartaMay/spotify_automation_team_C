package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;
import utilities.ConfigReader;
import utilities.Driver;

public class ChangeLanguage extends TestBase{

    @Test
    public void changeLanguage(){

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        new LoginPage().getLoginButton().click();
        //login
        new LoginPage().login("testuser1@example.com", "\"oB1/@kkPD\"");

        new ProfilePage().clickProfile();
        Driver.getDriver().findElement(By.xpath("//span[text()='Settings']")).click();

        new Select(Driver.getDriver().findElement(By.cssSelector(".zrvvPyoxE6wQNqnu0yWA"))).selectByVisibleText("Українська (Ukrainian)");

        Driver.getDriver().findElement(By.xpath("//button[text()='Reload']")).click();
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//select[@class='zrvvPyoxE6wQNqnu0yWA']")).isDisplayed());

        new ProfilePage().clickProfile();
        Driver.getDriver().findElement(By.xpath("//span[text()='Вийти']")).click();
    }

}
