package SeleniumWork;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass extends BaseClass {

    @Test
    public void orangeHRM() throws Exception {

        PageClass obj = new PageClass(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. Login 
        Thread.sleep(3000);
        obj.login("Admin", "admin123");


        // 2. Verify Dashboard
        Thread.sleep(3000);
        obj.verifyDashboard();
        Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed());

        // 3. Navigate to Admin
        Thread.sleep(3000);
        obj.clickAdmin();

        // 4. Search for Admin user
        Thread.sleep(3000);
        obj.searchUser("Admin");
        
        // 5. Verify Admin user
        Thread.sleep(3000);
        obj.verifyAdminUser();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@role='row']//div[@role='cell'][2][normalize-space()='Admin']")).isDisplayed());

        // 6. Screenshot
        screenshot();

        // 7. Logout
        Thread.sleep(3000);
        obj.logout();
    }
}
