import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 {
    @Test
    public void addSongToPlayList() throws InterruptedException{

        String strexpectedSongAddedMessage = "Added 1 song into myplaylist";
        String strSongName = "Pluto";
        String strEmail = "praveena.chitramanalan@testpro.io";
        String strPassword = "TestPro@0315";
        WebDriver driver = null;
        BaseTest baseTest = new BaseTest();

        baseTest.navigateToPage();
        baseTest.provideEmail(strEmail);
        baseTest.providePassword(strPassword);
        baseTest.clickSubmit();
        Thread.sleep(2000);

        //searchSong(strSongName);
        baseTest.clickViewAllBtn();
        baseTest.selectFirstSongResult();
        baseTest.clickAddToBtn();
        baseTest.choosePlayList();

        Assert.assertEquals(baseTest.getAddToPlayListSuccessMsg(),strexpectedSongAddedMessage);




    }

}
