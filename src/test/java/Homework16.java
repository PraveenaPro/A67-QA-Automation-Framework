
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Homework16 extends BaseTest {
    @Test
<<<<<<< Updated upstream
<<<<<<< Updated upstream
    public void registrationNavigation(){
        ChromeOptions options = new ChromeOptions();
=======
=======
>>>>>>> Stashed changes

    void registrationNavigation() {
        Chromeoptions options = new Chromeoptions();
>>>>>>> Stashed changes
        options.addArguments("remote allow");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        WebElement registrationLink = driver.findElement(By.cssSelector("[href='registration']"));
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        registrationLink.click();

        String registrationurl = "https://qa.koal.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(),registrationurl);
=======
=======
>>>>>>> Stashed changes
        registration.click();

        String registrationurl = "https://qa.koal.app/registration";
        Assert.arrertEquals(driver.getCurrentUrl(), registrationurl);
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes

        driver.quit();


    }
}