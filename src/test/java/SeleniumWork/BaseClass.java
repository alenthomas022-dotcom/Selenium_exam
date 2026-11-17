package SeleniumWork;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    public void screenshot() throws Exception {
        File s = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(s,new File("./Screenshots/OrangeHRM.png"));
        System.out.println("Screenshot captured successfully");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
