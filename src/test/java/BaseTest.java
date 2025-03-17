import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.net.URI;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver = null;
    WebDriverWait wait;
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public BaseTest(){

        super();
    }

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupDiver()throws MalformedURLException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        //driver = getBrowserDriver(System.getProperty("browser"));
        threadDriver.set(getBrowserDriver(System.getProperty("browser")));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        threadDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String url = "https://qa.koel.app/";
        //driver.manage().window().maximize();
        threadDriver.get().manage().window().maximize();
        //driver.get(url);
        threadDriver.get().get(url);
    }

    public WebDriver getDriver(){
        return threadDriver.get();
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver(){
        getDriver().quit();
    }


    public WebDriver getLambdaDriver() throws MalformedURLException{
        String userName= "praveena.jasmine";
        String authKey= "LT_CA9t44JXLBr0trcaqpegI25XIak1cul3djEzNG0d5XYog34";
        String hubURL= "https://hub.lamdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName","Chrome");
        capabilities.setCapability("browserVersion","130.0");
        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username",userName);
        ltOptions.put("accessKey",authKey);
        ltOptions.put("project", "Koel");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        ltOptions.put("platformName", "Windows 10");
        capabilities.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), capabilities);

    }

    public WebDriver getBrowserDriver(String browser) throws MalformedURLException {
        String gridUrl = "http://192.168.0.159:4444";
        DesiredCapabilities desiredCap = new DesiredCapabilities();
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
                return driver;
            case "grid-chrome":
                desiredCap.setBrowserName("chrome");
                driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), desiredCap);
                return driver;
            case "grid-firefox":
                desiredCap.setCapability("browserName", "firefox");
                driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), desiredCap);
                return driver;
            default:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                return driver;
        }
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

    public void clickDeletePlaylistBtn() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-delete-playlist")));
        deletePlaylist.click();
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