package SeleniumWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageClass {

    WebDriver driver;

    // Login elements

    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")WebElement username;
    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")WebElement password;
    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")WebElement loginButton;

    // Dashboard element
    @FindBy(xpath="//h6[text()='Dashboard']")WebElement dashboard;

    // Admin element
    @FindBy(xpath="//span[text()='Admin']")WebElement admin;

    // Search elements
    @FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")WebElement searchUsername;
    @FindBy(xpath="//button[@type='submit']")WebElement searchButton;
    @FindBy(xpath="//div[@role='row']//div[@role='cell'][2][normalize-space()='Admin']")WebElement adminUser;


    // Logout elements
    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span")WebElement profile;
    @FindBy(xpath="//a[text()='Logout']")WebElement logout;

 // Constructor
    public PageClass(WebDriver driver) 
    {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    }
    
    // Login method
    public void login(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        loginButton.click();
    }

    // Verify Dashboard
    public void verifyDashboard() {
        dashboard.isDisplayed();
        System.out.println("Dashboard displayed successfully");
    }

    // Navigate to Admin
    public void clickAdmin() {
        admin.click();
    }

    // Search Admin user
    public void searchUser(String user) {
        searchUsername.sendKeys(user);
        searchButton.click();
    }

    // Verify Admin user
    public void verifyAdminUser() {
        adminUser.isDisplayed();
        System.out.println("Admin user found successfully");
    }

    // Logout
    public void logout() {
        profile.click();
        logout.click();
        System.out.println("Logout successful");
    }
}

