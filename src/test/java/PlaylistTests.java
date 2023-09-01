import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.Assert;
public class PlaylistTests extends BaseTest {

    @Test
    public void deletePlaylist () throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        DeletePlaylistPage deletePlaylistPage = new DeletePlaylistPage(getDriver());
        String deleteMsg = "Deleted playlist";
        loginPage.provideEmail("beomseo.park@testpro.io").providePassword("te$t$tudent").clickSubmit();
        deletePlaylistPage.rightClickPlaylist();
        deletePlaylistPage.deleteItem();
        deletePlaylistPage.deleteBtn();
        Assert.assertTrue(DeletePlaylistPage.getDeleteMsg().contains(deleteMsg));

    }





    @Test
    public void renamePlaylist () throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        RenamePlaylistPage renamePlaylistPage = new RenamePlaylistPage(getDriver());
        DeletePlaylistPage deletePlaylistPage = new DeletePlaylistPage(getDriver());
        loginPage.provideEmail("beomseo.park@testpro.io").providePassword("te$t$tudent").clickSubmit();
        deletePlaylistPage.rightClickPlaylist();
        renamePlaylistPage.clickEdit();
        renamePlaylistPage.rename("66");
    }

    @Test
    public void playSongTest () throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        PlaySongPage playSongPage = new PlaySongPage(getDriver());
        loginPage.provideEmail("beomseo.park@testpro.io").providePassword("te$t$tudent").clickSubmit();
        playSongPage.clickPlayNext();
        playSongPage.clickPlay();

    }

    @Test
    public void addSongToPlaylistTest () throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        AddSongToPlayListPage addSongToPlayListPage = new AddSongToPlayListPage(getDriver());
        loginPage.provideEmail("beomseo.park@testpro.io").providePassword("te$t$tudent").clickSubmit();
        addSongToPlayListPage.searchSong("pluto");
        addSongToPlayListPage.clickViewAllBtn();
        addSongToPlayListPage.selectFirstSong();
        addSongToPlayListPage.clickAddToBtn();
        addSongToPlayListPage.choosePlayList();


    }

}
