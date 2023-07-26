import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseDriver;
import utilities.MyMethods;

import java.time.Duration;
import java.util.regex.Pattern;

public class TestCase4_Jazeera extends BaseDriver {

    @Test
    public void TestCase4(){

        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        MyMethods.myWait(2);

        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='username']"));
        usernameInput.sendKeys("Jazeeera");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("qwerty123");

        MyMethods.myWait(2);
        WebElement logIn = driver.findElement(By.xpath("//input[@type='submit']"));
        logIn.click();
        MyMethods.myWait(2);

        WebElement updateContactInfoButton = driver.findElement(By.xpath("//a[.='Update Contact Info']"));
        updateContactInfoButton.click();

        WebElement updateLastName = driver.findElement(By.xpath("//input[@id='customer.lastName']"));
        updateLastName.sendKeys("Arinova");

        WebElement updateAddress = driver.findElement(By.id("customer.address.street"));
        updateAddress.sendKeys(" 24 Pompton Lakes street");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.
                textMatches(By.xpath("//div[@id='customer.phoneNumber']"), Pattern.compile("234 563 5665")));

        WebElement updateProfileButton = driver.findElement(By.xpath("//input[@value='Update Profile']"));
        updateProfileButton.click();

        WebElement profileUpdatedMessage = driver.findElement(By.xpath("//h1[.='Profile Updated']"));
        Assert.assertTrue("Test is Failed",profileUpdatedMessage.getText().contains("Updated") );

        System.out.println("Jazeera");

        waitAndQuit();

               // Username:Jazeeera
               // Password: qwerty123

    }
}
