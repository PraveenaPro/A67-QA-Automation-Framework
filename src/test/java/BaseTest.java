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

    public void searchSong(String strname) throws InterruptedException{

        Thread.sleep(2000);
    }

    public void clickViewAllBtn() throws InterruptedException{
        WebElement clickViewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn')]"));
        Thread.sleep(2000);
    }

    public void selectFirstSongResult() throws InterruptedException{
        WebElement selectFirstSongResult = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item']"));
        Thread.sleep(2000);
    }

    public void provideEmail(String email) {
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }
    public void providePassword(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickAddToBtn() {
        WebElement addToBtn = driver.findElement (By.cssSelector("[data-test='add-to-btn']"));
        addToBtn.click();
    }

    public void clickSubmit() {
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();
    }

    public void choosePlayList()
    {
        WebElement choosePlayList = driver.findElement(By.xpath("//section[@id='songResultWrapper']//tr[@class='song-item']"));
                choosePlayList.click();
    }

    public void navigateToPage()
    {
        driver.navigate().to("https://qa.koel.app");
        System.out.println("visited koel page");
    }

    public String getAddToPlayListSuccessMsg(){
        String strMsg = "Added 1 song into myplaylist";
        return strMsg;
    }

    public void clickPlay() {

        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

        playButton.click();

    }

    public boolean isSongPlaying(){
        WebElement soundbar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundbar.isDisplayed();

    }

    public void playNextButton(){
        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        playNextButton.click();
    }



}