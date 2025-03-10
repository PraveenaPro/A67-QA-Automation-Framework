import POM.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 {
    @Test
    public void addSongToPlayList() throws InterruptedException{

        String strexpectedSongAddedMessage = "Added 1 song into myplaylist";
        String strSongName = "Pluto";
        String strEmail = "praveena.chitramanalan@testpro.io";
        String strPassword = "TestPro@0315";
        WebDriver driver = new ChromeDriver();
        BasePage basePage = new BasePage(driver);

        basePage.navigateToPage();
        basePage.provideEmail(strEmail);
        basePage.providePassword(strPassword);
        basePage.clickSubmit();
        Thread.sleep(2000);

        //searchSong(strSongName);
        basePage.clickViewAllBtn();
        basePage.selectFirstSongResult();
        basePage.clickAddToBtn();
        basePage.choosePlayList();

        Assert.assertEquals(basePage.getAddToPlayListSuccessMsg(),strexpectedSongAddedMessage);




    }

}
