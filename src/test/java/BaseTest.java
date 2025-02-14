import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;



    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setupDiver(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    public void clickViewAllBtn() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement clickViewAllBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-test='view-all-songs-btn')]")));

    }

    public void selectFirstSongResult() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement selectFirstSongResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item']")));

    }

    public void provideEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']")));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }
    public void providePassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']")));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickAddToBtn() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement addToBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='add-to-btn']")));
        addToBtn.click();
    }

    public void clickSubmit() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement submitLogin = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitLogin.click();
    }

    public void choosePlayList()
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement choosePlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultWrapper']//tr[@class='song-item']")));
        choosePlayList.click();
    }

    public void navigateToPage()
    {
        driver.navigate().to("https://qa.koel.app");
        System.out.println("visited koel page");
    }

    public String getAddToPlayListSuccessMsg(){
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

    public void clickPlay() {

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement playButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-testid='play-btn']")));
        playButton.click();

    }

    public boolean isSongPlaying(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement soundbar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='sound-bar-play']")));
        return soundbar.isDisplayed();

    }

    public void playNextButton(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement playNextButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@data-testid='play-next-btn']")));
        playNextButton.click();
    }

    public void clickDeletePlaylistBtn() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement deletePlaylist= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist")));
        deletePlaylist.click();
        Thread.sleep(2000);
    }
    public String getDeletedPlaylistMsg(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText();
    }
    public void openPlaylist()
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement emptyPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(6)")));
        emptyPlaylist.click();
    }



}