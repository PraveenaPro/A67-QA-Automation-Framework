package POM;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;


public class BasePage {
    protected  WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    @FindBy(css = "[type='submit']")
    private WebElement submitButtonLocator;

    @FindBy(css = "[type='email']")
    private  WebElement emailField;


    @FindBy(css = "[type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@data-test='view-all-songs-btn')]")
    private WebElement clickviewAll;

    @FindBy (xpath = "//section[@id='songResultsWrapper']//tr[@class='song-item']")
    private WebElement selectSongResult;

    @FindBy (css ="[data-test='add-to-btn']")
    private WebElement ClickAddBtn;

    @FindBy (xpath = "section[@id='songResultWrapper']//tr[@class='song-item']")
    private WebElement ChoosePlay;

    @FindBy(css = "div.success.show")
    private WebElement PlayListSuccessMsg;

    @FindBy(css = "span[@data-testid='play-btn']" )
    private  WebElement ClickPlayList ;

    @FindBy(xpath ="div[@data-testid='sound-bar-play']" )
    private WebElement IsSongPlay;

    @FindBy(xpath = "i[@data-testid='play-next-btn']")
    private WebElement PlayNext;

    @FindBy(css = ".btn-delete-playlist")
    private WebElement ClickPlayBtn;

    @FindBy(css ="div.success.show")
    private WebElement getDeletedPlayMsg;

    @FindBy(css = ".playlist:nth-child(6)")
    private WebElement openList;

    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait =new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

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
        // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-test='view-all-songs-btn')]")));
            wait.until(ExpectedConditions.elementToBeClickable(clickviewAll));
    }

    public void selectFirstSongResult() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
       // WebElement selectFirstSongResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item']")));
        WebElement selectFirstSongResult = wait.until(ExpectedConditions.elementToBeClickable(selectSongResult));
    }

    public void provideEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        //WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']")));
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }
    public void providePassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        //WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']")));
        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickAddToBtn() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        //WebElement addToBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='add-to-btn']")));
        WebElement addToBtn = wait.until(ExpectedConditions.elementToBeClickable(ClickAddBtn));
        addToBtn.click();
    }

    public void clickSubmit() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
       // WebElement submitLogin = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        WebElement submitLogin = wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
        submitLogin.click();
    }

    public void choosePlayList()
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        //WebElement choosePlayList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='songResultWrapper']//tr[@class='song-item']")));
        WebElement choosePlayList = wait.until(ExpectedConditions.elementToBeClickable(ChoosePlay));
        choosePlayList.click();
    }

    public void navigateToPage()
    {
        driver.navigate().to("https://qa.koel.app");
        System.out.println("visited koel page");
    }

    public String getAddToPlayListSuccessMsg(){
       // WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return PlayListSuccessMsg.getText();
    }

    public void clickPlay() {

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
       // WebElement playButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-testid='play-btn']")));
        WebElement playButton = wait.until(ExpectedConditions.elementToBeClickable(ClickPlayList));
        playButton.click();

    }

    public boolean isSongPlaying(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        //WebElement soundbar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='sound-bar-play']")));
        WebElement soundbar = wait.until(ExpectedConditions.visibilityOf(IsSongPlay));
        return soundbar.isDisplayed();

    }

    public void playNextButton(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
       // WebElement playNextButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@data-testid='play-next-btn']")));
       WebElement playNextButton = wait.until(ExpectedConditions.visibilityOf(PlayNext));
        playNextButton.click();
    }

    public void clickDeletePlaylistBtn() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
       //WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist")));
        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOf(ClickPlayBtn));
        deletePlaylist.click();
    }
    public String getDeletedPlaylistMsg(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        //WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOf(getDeletedPlayMsg));
        return notificationMsg.getText();
    }
    public void openPlaylist()
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        //WebElement emptyPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(6)")));
        WebElement emptyPlaylist = wait.until(ExpectedConditions.visibilityOf(openList));
        emptyPlaylist.click();
    }




}
