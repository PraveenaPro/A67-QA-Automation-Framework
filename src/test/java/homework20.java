import POM.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test

    public class homework20
    {
        String expectedPlaylistDeletedMessage = "Deleted playlist \"Test1.\"";
        public void deletePlaylist() throws InterruptedException{

            BasePage basePage = new BasePage();
            basePage.provideEmail("praveena.chitramanalan@testpro.io");
            basePage.providePassword("TestPro@0315");
            //provideEmail("praveena.chitramanalan@testpro.io");
            //providePassword("TestPro@0315");
            basePage.clickPlay();
            //clickPlay();
            basePage.openPlaylist();
            //openPlaylist();
            basePage.clickDeletePlaylistBtn();
            // clickDeletePlaylistBtn();
            Assert.assertEquals(basePage.getDeletedPlaylistMsg(), expectedPlaylistDeletedMessage);
            //Assert.assertEquals(getDeletedPlaylistMsg(), expectedPlaylistDeletedMessage);

        }


    }





