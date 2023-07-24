
import org.junit.Assert;
import org.junit.Test;
import utilities.BaseDriver;
import utilities.MyMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class TestCase1_Fatih extends BaseDriver {

    @Test
    public void TestCaseOne() {

        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        //driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm");


        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Jazeeera");

        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys("qwerty123");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(userName, "value"));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(pass, "value"));

        WebElement LoginButton = driver.findElement(By.cssSelector("input[type='submit'][class='button']"));
        LoginButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Open New Account']")));
        WebElement OpenNewAcc = driver.findElement(By.xpath("//a[text()='Open New Account']"));
        OpenNewAcc.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='submit'][class='button']")));

        WebElement accType = driver.findElement(By.id("type"));
        Select type = new Select(accType);
        type.selectByIndex(1);

        WebElement accform = driver.findElement(By.id("fromAccountId"));

        MyMethods.myWait(2);

        WebElement clickOpenNewAccount = driver.findElement(By.xpath("//input[@type='submit'][@class='button']"));
        clickOpenNewAccount.click();

        WebElement succesfullyOpenNewAccount = driver.findElement(By.xpath("//h1[text()='Account Opened!']"));
        Assert.assertTrue("Test is Failed", succesfullyOpenNewAccount.getText().contains("Opened"));

        waitAndQuit();


    }
}