import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseDriver;
import utilities.MyMethods;

public class TestCase4_Jazeera extends BaseDriver {

    @Test
    public void TestCase4(){

        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        MyMethods.myWait(2);

        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='username']"));
        usernameInput.sendKeys("Jazeera");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("qwerty123");


        WebElement logIn = driver.findElement(By.xpath("//input[@type='submit']"));
        logIn.click();
        MyMethods.myWait(2);
//
//        WebElement welcomeMessage = driver.findElement(By.xpath("//h1[@class='title']"));
//        Assert.assertTrue("Test is Failed",welcomeMessage.getText().contains("Welcome") );
        waitAndQuit();

               // Username:Jazeera
               // Password: qwerty123

    }
}
