
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import sun.font.TrueTypeFont;

import java.io.File;
import java.util.NoSuchElementException;

public class TestBase{

    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite(alwaysRun = true, description = "Setup driver")

    public void setup(){
        ChromeDriverService serviceChrome = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:/!!Lektorium/lektroium3/src/main/resources/chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("start-maximized");
        driver = new ChromeDriver(serviceChrome, optionsChrome);
        driver.get("https://www.udacity.com/");
        wait = new WebDriverWait(driver, 200);

        try{

        } catch (Exception e){

        }

    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        driver.quit();

    }
    @BeforeMethod
    public void login(){

        WebElement signElement = driver.findElement(By.xpath("(//a[@title='Sign In'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(signElement));
        signElement.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException | NoSuchElementException e) {
            System.out.println("No such element");
            e.printStackTrace();
        }

        WebElement emailElement = driver.findElement(By.xpath("//input[@type='email']"));
        wait.until(ExpectedConditions.elementToBeClickable(emailElement));
        emailElement.clear();
        emailElement.sendKeys("testmailforus9@gmail.com");

        WebElement passwordElement = driver.findElement(By.xpath("//input[@type='password']"));
        wait.until(ExpectedConditions.elementToBeClickable(passwordElement));
        passwordElement.clear();
        passwordElement.sendKeys("trash1010");

        WebElement submitElement = driver.findElement(By.xpath("//form/button[text()='Sign In']"));
        wait.until(ExpectedConditions.elementToBeClickable(submitElement));
        submitElement.click();

        WebElement assertElement = driver.findElement(By.xpath("(//*[contains(@href,'www.udacity.com')])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(assertElement));

        wait.until(ExpectedConditions.urlToBe("https://classroom.udacity.com/me"));
        WebElement settingElement = driver.findElement(By.xpath("//span[@title='Settings']"));
        wait.until(ExpectedConditions.elementToBeClickable(settingElement));
        settingElement.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException | NoSuchElementException e) {
            System.out.println("No such element");
            e.printStackTrace();
        }

    }
    @AfterMethod
    public void logout(){
        driver.get("https://classroom.udacity.com/me");
        WebElement submitElement = driver.findElement(By.xpath("//span[contains(text(), 'Logout')]"));
        wait.until(ExpectedConditions.elementToBeClickable(submitElement));
        submitElement.click();


    }
}