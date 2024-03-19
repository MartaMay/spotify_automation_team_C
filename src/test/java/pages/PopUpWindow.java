package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.SeleniumUtils;

@Data
public class PopUpWindow {
    public PopUpWindow(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div[class='Popover__StyledPopover-sc-1iog353-0 hUICWc encore-announcement-set cKHK53VIATgkMZYQDfol']")
    private WebElement popUpWindow;

    public WebElement getPopUpWindow() {
        return popUpWindow;
    }

    public void closePopUp(){
        try {
            SeleniumUtils.waitForVisibility(Driver.getDriver().findElement(By.xpath("//div[@class='Popover__StyledPopover-sc-1iog353-0 hUICWc encore-announcement-set cKHK53VIATgkMZYQDfol']")), 5);
            Driver.getDriver().findElement(By.cssSelector("button[class='Button-sc-1dqy6lx-0 emaScS QMGfkFWtxrVkgNgFXDyw']")).click();

        }catch (NoSuchElementException ignored){
        }
    }
}
