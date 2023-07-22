import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseDriver;
import utilities.MyMethods;

public class BaseTestCase_Jazeera extends BaseDriver {

    @Test
    public void BaseTestCase(){

        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        MyMethods.myWait(2);

        WebElement registerButton = driver.findElement(By.xpath("//a[.='Register']"));

        registerButton.click();

        WebElement firstName = driver.findElement(By.id("customer.firstName"));
        firstName.sendKeys("Jazeera");

        WebElement lastName = driver.findElement(By.id("customer.lastName"));
        lastName.sendKeys("Arin");

        WebElement address = driver.findElement(By.id("customer.address.street"));
        address.sendKeys(" 24 Wayne street");

        WebElement city = driver.findElement(By.id("customer.address.city"));
        city.sendKeys("Wayne");

        WebElement state = driver.findElement(By.id("customer.address.state"));
        state.sendKeys("NJ");

        WebElement zipCode = driver.findElement(By.id("customer.address.zipCode"));
        zipCode.sendKeys("23456");

        WebElement phoneNumber = driver.findElement(By.id("customer.phoneNumber"));
        phoneNumber.sendKeys("234 563 5665");

        WebElement ssn = driver.findElement(By.id("customer.ssn"));
        ssn.sendKeys("234 563 566");

        WebElement userName = driver.findElement(By.id("customer.username"));
        userName.sendKeys("Jazeeera");

        WebElement password = driver.findElement(By.id("customer.password"));
        password.sendKeys("qwerty123");

        WebElement confirmPassword = driver.findElement(By.id("repeatedPassword"));
        confirmPassword.sendKeys("qwerty123");
        MyMethods.myWait(2);

        WebElement register = driver.findElement(By.xpath("//input[@type='submit'] [@value='Register']"));
        register.click();

        MyMethods.myWait(2);
        WebElement welcomeMessage = driver.findElement(By.xpath("//h1[@class='title']"));
        Assert.assertTrue("Test is Failed",welcomeMessage.getText().contains("Welcome") );
        waitAndQuit();

               // Username:Jazeera
               // Password: qwerty123

    }
}
