package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BaseDriver{

        public static WebDriver driver;

        static  {

            Logger logger = Logger.getLogger(""); // Shows only severe problems on the console
            logger.setLevel(Level.SEVERE);

            driver = new ChromeDriver();
            driver.manage().window().maximize();   // fits the browser to the screen

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15)); // checks if the page is loaded
            // Waits for 15 sec for page to be loaded
            // if it takes more than 15 secs to a page being loaded it throws an exception
            // PageLoad = waits all html files are downloaded to our computer, but they are not visible on our browser yet

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // checks if the elements are visible
            // ImplicitlyWait = waits until all elements on a webpage are visible on our browser.
            // if it is not done in 15 secs it throws an exception.


        }

        public static void waitAndQuit() {
            MyMethods.myWait(1);
            driver.quit();

        }

        public static void closePreviousDrivers() {
            try {
                Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
}

