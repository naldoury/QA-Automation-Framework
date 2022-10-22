import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.InterruptedIOException;
import java.time.Duration;

public class registration {

        @Test
        public static void registrationNavigation() throws InterruptedException
        {

            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String url = "https://bbb.testpro.io/";
            driver.get(url);
            Assert.assertEquals(driver.getCurrentUrl(), url);

            WebElement registrationLinkElement=driver.findElement(new By.ById("hel"));
            registrationLinkElement.click();


            Thread.sleep(5000);
            driver.quit();
        }

    }
