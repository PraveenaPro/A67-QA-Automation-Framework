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

            BaseTest baseTest = new BaseTest();
            baseTest.provideEmail("praveena.chitramanalan@testpro.io");
            baseTest.providePassword("TestPro@0315");
            //provideEmail("praveena.chitramanalan@testpro.io");
            //providePassword("TestPro@0315");
            baseTest.clickPlay();
            //clickPlay();
            baseTest.openPlaylist();
            //openPlaylist();
            baseTest.clickDeletePlaylistBtn();
            // clickDeletePlaylistBtn();
            Assert.assertEquals(baseTest.getDeletedPlaylistMsg(), expectedPlaylistDeletedMessage);
            //Assert.assertEquals(getDeletedPlaylistMsg(), expectedPlaylistDeletedMessage);

        }


    }





