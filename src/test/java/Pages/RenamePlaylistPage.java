package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

public class RenamePlaylistPage extends BasePage{
    public RenamePlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy (css ="#playlists > ul > li:nth-child(3) > nav > ul > li:nth-child(1)" )
    private WebElement  edit;

    @FindBy (css ="[name='name']")
    private WebElement  naming;


    public RenamePlaylistPage clickEdit() {
        edit.click();
        return this;
    }
    public RenamePlaylistPage rename(String playlistName) {
        naming.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        naming.sendKeys(playlistName);
        naming.sendKeys(Keys.RETURN);
        return this;
    }


    public  String doesPlaylistExist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return playlistElement.getText();
    }
}
