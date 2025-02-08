import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    WebDriver driver = new ChromeDriver();

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
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



}