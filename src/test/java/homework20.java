import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

    public class homework20 extends BaseTest
    {
        String expectedPlaylistDeletedMessage = "Deleted playlist \"Test1.\"";
        public void deletePlaylist() throws InterruptedException{
            provideEmail("praveena.chitramanalan@testpro.io");
            providePassword("TestPro@0315");
            clickPlay();
            openPlaylist();
            clickDeletePlaylistBtn();
            Assert.assertEquals(getDeletedPlaylistMsg(), expectedPlaylistDeletedMessage);

        }


    }





