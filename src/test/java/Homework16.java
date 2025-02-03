import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends Baseclass {
    @Test
    Public void registrationNavigation(){
        Chromeoptions options = new Chromeoptions();
        options.addArguments("remote allow");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        WebElement registrationLink = driver.findElement(By.cssSelector("[href='registration']");
        registration.click();

        String registrationurl = "https://qa.koal.app/registration";
        Assert.arrertEquals(driver.getCurrentUrl(),registrationurl);

        driver.quit();


}
