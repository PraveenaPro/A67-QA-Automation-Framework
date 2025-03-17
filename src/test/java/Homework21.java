import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import javax.swing.*;
import java.time.Duration;

@Test

public class Homework21 {
    public String newPlaylistName = "Sample Edited Playlist";
    public BaseTest baseTest = new BaseTest();
    public void doubleClickPlaylist() {
        WebDriverWait wait = new WebDriverWait(baseTest.getDriver(), Duration.ofSeconds(30));
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        new Actions(baseTest.getDriver()).doubleClick(playlistElement).perform();
    }
    public void enterNewPlaylistName(){
        WebDriverWait wait = new WebDriverWait(baseTest.getDriver(), Duration.ofSeconds(30));
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public String getRenamePlaylistSuccessMsg(){
        WebDriverWait wait = new WebDriverWait(baseTest.getDriver(), Duration.ofSeconds(30));
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

}
