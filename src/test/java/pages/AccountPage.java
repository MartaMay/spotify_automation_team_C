package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

@Data
public class AccountPage {

    public AccountPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
//testing
    @FindBy(xpath ="//span[text()='Account']")
    private WebElement account;

    public WebElement getAccount(){ return account; }

    public void clickAccount(){ account.click();}
}
