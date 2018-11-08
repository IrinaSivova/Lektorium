
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.NoSuchElementException;

public class Testabc{

   // @FindBy(xpath = "//a[@href='https://my.rozetka.com.ua/ua/signin/']")
   // private WebElement signInLink;

    WebDriver driver;

    @Test
    public void start(){
        ChromeDriverService serviceChrome = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:/!!Lektorium/lektroium3/src/main/resources/chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("start-maximized");
        driver = new ChromeDriver(serviceChrome, optionsChrome);
        driver.get("https://www.udacity.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 50);

       /* WebElement popAdvet = driver.findElement(By.xpath("//div[@class='modal-close']"));
        wait.until(ExpectedConditions.elementToBeClickable(popAdvet));
        popAdvet.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException | NoSuchElementException e) {
            System.out.println("No such element");
            e.printStackTrace();
        } */


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

        try {
            Thread.sleep(2000);
        } catch (InterruptedException | NoSuchElementException e) {
            System.out.println("No such element");
            e.printStackTrace();
        }

        WebElement passwordElement = driver.findElement(By.xpath("//input[@type='password']"));
        wait.until(ExpectedConditions.elementToBeClickable(passwordElement));
        passwordElement.clear();
        passwordElement.sendKeys("trash1010");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException | NoSuchElementException e) {
            System.out.println("No such element");
            e.printStackTrace();
        }

        WebElement submitElement = driver.findElement(By.xpath("//form/button[text()='Sign In']"));
        wait.until(ExpectedConditions.elementToBeClickable(submitElement));
        submitElement.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException | NoSuchElementException e) {
            System.out.println("No such element");
            e.printStackTrace();
        }

       /* WebElement assertElement = driver.findElement(By.xpath("(//*[contains(@href,'www.udacity.com')])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(assertElement));
        Assert.assertTrue(assertElement.isDisplayed());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException | NoSuchElementException e) {
            System.out.println("No such element!");
            e.printStackTrace();
        }*/
        driver.quit();
    }
}
