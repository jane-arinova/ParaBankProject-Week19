import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCase3_Yernar extends BaseDriver{
    @Test
    public void Test() {

        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("johns");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("johns123");

        WebElement logIn = driver.findElement(By.xpath("//input[@type='submit']"));
        logIn.click();

        WebElement transferFunds = driver.findElement(By.xpath("//a[text()='Transfer Funds']"));
        transferFunds.click();

        WebElement amount = driver.findElement(By.xpath("//input[@name='accounts.amount']"));
        amount.sendKeys("100");

        WebElement fromAccount = driver.findElement(By.xpath("//[@name='accounts.fromAccountId']"));
        fromAccount.select(16674);

        WebElement toAccount = driver.findElement(By.xpath("//[@name='accounts.toAccountId']"));
        toAccount.select(16785);

        WebElement transfer = driver.findElement(By.cssSelector("[value='Transfer']"));
        transfer.click();

        WebElement check = driver.findElement(By.xpath("//h1[text()='Transfer Complete']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.xpath("//h1[text()='Transfer Complete']"), "Transfer Complete"));
        Assert.assertEquals("Test Failed", "Bill Payment Complete", check.getText());
        Assert.assertTrue("Test Failed", check.getText().equals("Transfer Complete"));
        System.out.println("1234");

    }
}
