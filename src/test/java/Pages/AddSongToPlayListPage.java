package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddSongToPlayListPage extends BasePage{

    public AddSongToPlayListPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css ="div#searchForm input[type=search]" )
    private WebElement searchField;

    @FindBy (css ="#searchExcerptsWrapper > div > div > section.songs > h1 > button" )
    private WebElement  viewAllSearchResult;

    @FindBy (css ="#songResultsWrapper > div > div > div.item-container > table > tr" )
    private WebElement  firstSongResult;

    @FindBy (css ="#songResultsWrapper > header > div.song-list-controls > span > button.btn-add-to" )
    private WebElement  addToBtn;

    @FindBy (xpath ="//*[@id='songResultsWrapper']/header/div[3]/div/section[1]/ul/li[5]" )
    private WebElement  playlist;


    public AddSongToPlayListPage searchSong(String songTitleKeyword) {
        searchField.clear();
        searchField.sendKeys(songTitleKeyword);
        return this;
    }

    public AddSongToPlayListPage clickViewAllBtn() {
        viewAllSearchResult.click();
        return this;
    }

    public AddSongToPlayListPage selectFirstSong() {
        firstSongResult.click();
        return this;
    }

    public AddSongToPlayListPage clickAddToBtn() {
        addToBtn.click();
        return this;
    }

    public AddSongToPlayListPage choosePlayList() {
        playlist.click();
        return this;
    }

}
