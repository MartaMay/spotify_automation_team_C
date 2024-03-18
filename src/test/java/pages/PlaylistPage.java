package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PlaylistPage {

    public PlaylistPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText="Playlists")
    private WebElement playlist;

    public WebElement getPlaylist(){ return playlist; }

    public void clickPlaylist(){ playlist.click();}
}
