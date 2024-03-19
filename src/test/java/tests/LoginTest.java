package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.html.HTMLInputElement;
import pages.LoginPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

import javax.security.auth.kerberos.KeyTab;
import javax.swing.*;
import java.io.IOException;


public class LoginTest extends TestBase {

    @Test (groups = "smoke")
    public void testValidCredentials() throws IOException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        new LoginPage().getLoginButton().click();
        new LoginPage().login();
        new LoginPage().login(ConfigReader.getProperty("username"), Keys.TAB, ConfigReader.getProperty("password"), Keys.ENTER);

    }
    @Test
    public void testInvalidCredentials()throws IOException{
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        new LoginPage().getLoginButton().click();
        new LoginPage().login();
        new LoginPage().getUserNameField().sendKeys("bla", Keys.TAB,"blabla", Keys.ENTER );

    }

    @Test
    public void testInvalidCredentialsNoUsername(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        new LoginPage().getLoginButton().click();
        new LoginPage().login();
        new LoginPage().getUserNameField().sendKeys("", Keys.TAB, "invalid", Keys.ENTER);

    }
    @Test
    public void testInvalidCredentialsNoPassword(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        new LoginPage().getLoginButton().click();
        new LoginPage().login();
        new LoginPage().getUserNameField().sendKeys("hoho", Keys.TAB, "", Keys.ENTER);

    }
    @Test (groups = "smoke")
    public void testInvalidCredentialsNoCred(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        new LoginPage().getLoginButton().click();
        new LoginPage().login();
        new LoginPage().getUserNameField().sendKeys("", Keys.TAB, "", Keys.ENTER);

    }@Test
    public void testRememberMeCheckbox(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        new LoginPage().getLoginButton().click();
        new LoginPage().login();
        new LoginPage().getUserNameField().sendKeys("username", Keys.TAB,"Password",Keys.TAB, Keys.ENTER);


    }
}
