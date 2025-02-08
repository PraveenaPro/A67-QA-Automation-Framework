import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{
    @Test
    public void addSongToPlayList() throws InterruptedException{

        String strexpectedSongAddedMessage = "Added 1 song into myplaylist";
        String strSongName = "Pluto";
        String strEmail = "praveena.chitramanalan@testpro.io";
        String strPassword = "TestPro@0315";

        navigateToPage();
        provideEmail(strEmail);
        providePassword(strPassword);
        clickSubmit();
        Thread.sleep(2000);

        searchSong(strSongName);
        clickViewAllBtn();
        selectFirstSongResult();
        clickAddToBtn();
        choosePlayList();

        Assert.assertEquals(getAddToPlayListSuccessMsg(),strexpectedSongAddedMessage);




    }

}
