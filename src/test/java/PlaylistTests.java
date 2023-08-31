import Pages.*;
import org.testng.annotations.Test;
import org.testng.Assert;

import static Pages.LoginPage.openLoginUrl;

public class PlaylistTests extends BaseTest {

    @Test
    public void deletePlaylist () throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        DeletePlaylistPage deletePlaylistPage = new DeletePlaylistPage(getDriver());
        String deleteMsg = "Deleted playlist";
        openLoginUrl();
        loginPage.provideEmail("beomseo.park@testpro.io").providePassword("te$t$tudent").clickSubmit();
        deletePlaylistPage.openPlaylist();
        deletePlaylistPage.deleteItem();
        deletePlaylistPage.deleteBtn();
        Assert.assertTrue(DeletePlaylistPage.getDeleteMsg().contains(deleteMsg));
    }



    @Test
    public void renamePlaylist () throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        RenamePlaylistPage renamePlaylistPage = new RenamePlaylistPage(getDriver());
        openLoginUrl();
        loginPage.provideEmail("beomseo.park@testpro.io").providePassword("te$t$tudent").clickSubmit();
        renamePlaylistPage.openOption();
        renamePlaylistPage.clickEdit();
        renamePlaylistPage.rename("66");
    }

    @Test
    public void playSongTest () throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        PlaySongPage playSongPage = new PlaySongPage(getDriver());
        openLoginUrl();
        playSongPage.clickPlayNext();
        playSongPage.clickPlay();

    }

    @Test
    public void addSongtoPlaylistTest () throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        AddSongToPlayListPage addSongToPlayListPage = new AddSongToPlayListPage(getDriver());
        openLoginUrl();
        addSongToPlayListPage.searchSong("pluto");
        addSongToPlayListPage.clickViewAllBtn();
        addSongToPlayListPage.selectFirstSong();
        addSongToPlayListPage.clickAddToBtn();
        addSongToPlayListPage.choosePlayList();


    }

}
