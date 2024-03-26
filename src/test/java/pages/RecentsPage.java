package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

@Data
public class RecentsPage {

    public RecentsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//span[@class='Text__TextElement-sc-if376j-0 gYdBJW encore-text-body-small mdvwJxMDgGjicVAZoBAw']")
    private WebElement recentsPage;

    public WebElement getRecentsPage(){ return recentsPage; }
    public void clickRecentsPage(){ recentsPage.click();}
}
