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

    @FindBy (id="login-remember")
    private WebElement rememberMeCheckbox;

    public WebElement getUserNameField() {
        return userNameField;
    }

    public WebElement getLoginButton() { return  loginButton; }

    public WebElement clickRememberMeCheckbox(){
        return rememberMeCheckbox;
    }

    public void login(String username, String password){
        userNameField.sendKeys(ConfigReader.getProperty(username), Keys.TAB, ConfigReader.getProperty(password), Keys.ENTER);

    }
    public void login(){
        userNameField.sendKeys(ConfigReader.getProperty("username"), Keys.TAB, ConfigReader.getProperty("password"), Keys.ENTER);

    }

    public void login(String username, Keys keys, String password, Keys keys1) {
    }
    public void rememberMeCheckbox(){
      rememberMeCheckbox.click();

    }
}