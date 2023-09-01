package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DeletePlaylistPage extends BasePage{

    public DeletePlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css ="a[href='#!/playlist/69751']" )
    private WebElement accessPlaylist;

    @FindBy (css =".del" )
    private WebElement  item;

    @FindBy (css ="button.ok" )
    private WebElement  btn;


    @FindBy(css = "div.success.show")
    private static WebElement deleteMsg;

    public DeletePlaylistPage openPlaylist() {
        accessPlaylist.click();
        return this;
    }

    public DeletePlaylistPage deleteItem() {
        item.click();
        return this;
    }
    public DeletePlaylistPage deleteBtn() {
        btn.click();
        return this;
    }
    public static String  getDeleteMsg() {
        return deleteMsg.getText();
    }


    public DeletePlaylistPage rightClickPlaylist(){
        contextClick(accessPlaylist);
        return this;
    }

    public DeletePlaylistPage doubleClickPlaylist (){
        doubleClick(accessPlaylist);
        return this;
    }
}
