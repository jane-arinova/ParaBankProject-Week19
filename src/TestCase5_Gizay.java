import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseDriver;
import utilities.MyMethods;

public class TestCase5_Gizay extends BaseDriver {

    @Test
    public void TestCase5() {

        driver.get("https://parabank.parasoft.com/parabank/index.htm");


        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Jazeeera");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("qwerty123");
        MyMethods.myWait(4);

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        WebElement requestLoanLink = driver.findElement(By.linkText("Request Loan"));
        requestLoanLink.click();

        WebElement loanAmountInput = driver.findElement(By.name("amount"));
        WebElement downPaymentInput = driver.findElement(By.name("downPayment"));

        loanAmountInput.sendKeys("1000");
        downPaymentInput.sendKeys("100");

        WebElement applyNowButton = driver.findElement(By.xpath("//input[@value='Apply Now']"));
        applyNowButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//h1[contains(text(), 'Congratulations')]"));
        Assert.assertTrue(successMessage.getText().contains("Congratulations"));




        driver.quit();
    }
}
