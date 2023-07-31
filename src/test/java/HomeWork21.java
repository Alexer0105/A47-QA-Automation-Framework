import org.testng.annotations.Test;
import org.testng.Assert;
public class HomeWork21 extends BaseTest{

    @Test
    public void renamePlaylist () throws InterruptedException {
        openLoginUrl();
        enterEmail("beomseo.park@testpro.io");
        enterPassword("te$t$tudent");
        clickSubmit();
        openOption();
        clickEdit();
        rename("66");
        String newPlaylistName = "Updated playlist";
        Assert.assertTrue(doesPlaylistExist().contains(newPlaylistName));

    }
}