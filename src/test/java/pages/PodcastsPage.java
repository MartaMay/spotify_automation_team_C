package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


@Data
public class PodcastsPage {

    public PodcastsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText="Podcasts")
    private WebElement podcasts;

    public WebElement getPodcasts(){ return podcasts; }

    public void clickPodcasts(){ podcasts.click();}
}
