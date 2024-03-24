package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

@Data
public class LogOut {

    public LogOut(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath ="//span[text()='Log out']")
    private WebElement logOut;

    public WebElement getLogOut(){ return logOut; }

    public void clickLogOut(){ logOut.click();}
}
