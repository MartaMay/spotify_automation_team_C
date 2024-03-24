package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

@Data
public class ProfilePage {

    public ProfilePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath ="//span[@data-testid='username-first-letter']")
    private WebElement profile;

    public WebElement getProfile(){ return profile; }

    public void clickProfile(){ profile.click();}
}
