import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.MyMethods;

import java.time.Duration;

import static utilities.BaseDriver.driver;

public class TestCase2_Baran {

    @Test
    public void Test() {

        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("BaranGurses");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("1234567");

        WebElement logIn = driver.findElement(By.xpath("//input[@type='submit']"));
        logIn.click();


        WebElement billPay = driver.findElement(By.xpath("//a[text()='Bill Pay']"));
        billPay.click();

        WebElement payee = driver.findElement(By.xpath("//input[@name='payee.name']"));
        payee.sendKeys("Baran");

        WebElement address = driver.findElement(By.xpath("//input[@name='payee.address.street']"));
        address.sendKeys("Chase Ave");

        WebElement city = driver.findElement(By.xpath("//input[@name='payee.address.city']"));
        city.sendKeys("Rutherford");

        WebElement state = driver.findElement(By.xpath("//input[@name='payee.address.state']"));
        state.sendKeys("New Jersey");

        WebElement zipCode = driver.findElement(By.xpath("//input[@name='payee.address.zipCode']"));
        zipCode.sendKeys("07072");

        WebElement phone = driver.findElement(By.xpath("//input[@name='payee.phoneNumber']"));
        phone.sendKeys("2014475258");

        WebElement accNumber = driver.findElement(By.xpath("//input[@name='payee.accountNumber']"));
        accNumber.sendKeys("123456");

        WebElement verifyAccNumber = driver.findElement(By.xpath("//input[@name='verifyAccount']"));
        verifyAccNumber.sendKeys("123456");

        WebElement amount = driver.findElement(By.xpath("//input[@name='amount']"));
        amount.sendKeys("10000");

        WebElement fromAccount = driver.findElement(By.xpath("//select[@name='fromAccountId']"));
        Select fromAcc = new Select(fromAccount);
        fromAcc.selectByValue("14454");

        WebElement sendPayment = driver.findElement(By.cssSelector("[value='Send Payment']"));
        sendPayment.click();

        WebElement check = driver.findElement(By.xpath("//h1[text()='Bill Payment Complete']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.xpath("//h1[text()='Bill Payment Complete']"), "Bill Payment Complete"));
        Assert.assertEquals("Test Failed", "Bill Payment Complete", check.getText());
        //Assert.assertTrue("Test Failed",check.getText().equals("Bill Payment Complete"));
    }
}






