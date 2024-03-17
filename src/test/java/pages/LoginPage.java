package pages;

import lombok.Data;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

@Data
public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (css = "button[data-testid='login-button']")
    private  WebElement loginButton;
    @FindBy (id = "login-username")
    private  WebElement userNameField;

    public WebElement getUserNameField() {
        return userNameField;
    }

    public WebElement getLoginButton() { return  loginButton; }

    public void login(String username, String password){
        userNameField.sendKeys(ConfigReader.getProperty(username), Keys.TAB, ConfigReader.getProperty(password), Keys.ENTER);

    }
    public void login(){
        userNameField.sendKeys(ConfigReader.getProperty("username"), Keys.TAB, ConfigReader.getProperty("password"), Keys.ENTER);

    }

}
