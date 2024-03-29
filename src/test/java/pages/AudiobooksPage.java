package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

@Data
public class AudiobooksPage {

    public AudiobooksPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText="Audiobooks")
    private WebElement audiobooks;

    public WebElement getAudiobooks(){ return audiobooks; }

    public void clickAudiobooks(){ audiobooks.click();}
}
