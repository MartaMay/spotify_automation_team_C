package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

@Data
public class ExtendLibraryPage {

    public ExtendLibraryPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//button[@aria-label='Enlarge Your Library']")
    private WebElement extendLibrary;

    public WebElement getExtendLibrary(){ return extendLibrary; }

    public void clickExtendLibrary(){ extendLibrary.click();}
}
