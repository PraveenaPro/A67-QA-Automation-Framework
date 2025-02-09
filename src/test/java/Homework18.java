import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() {
        provideEmail("praveena.chitramanalan@testpro.io");
        providePassword("TestPro@0315");
        clickSubmit();
        clickPlay();
        Assert.assertTrue(isSongPlaying());
    }

}
