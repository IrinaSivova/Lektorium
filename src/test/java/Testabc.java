
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.File;
import java.util.NoSuchElementException;


public class Testabc extends TestBase {

     // @FindBy(xpath = "//a[@href='https://my.rozetka.com.ua/ua/signin/']")
     // private WebElement signInLink;


     @Test
     public void compare () {

         wait.until(ExpectedConditions.urlToBe("https://classroom.udacity.com/settings/personal-info"));
         WebElement nameField = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
         wait.until(ExpectedConditions.visibilityOf(nameField));
         String valueNameField = nameField.getAttribute("value");
         String expectedName = "Mike";
         Assert.assertEquals(valueNameField, expectedName);


         try {
             Thread.sleep(2000);
         } catch (InterruptedException | NoSuchElementException e) {
             System.out.println("No such element");
             e.printStackTrace();
         }

         WebElement lastField = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
         String valueLastFiield = lastField.getAttribute("value");
         Assert.assertEquals(valueLastFiield, "Lebowski");

         WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
         String valueEmailField = emailField.getAttribute("value");
         Assert.assertEquals(valueEmailField, "testmailforus9@gmail.com");

     }
 }




