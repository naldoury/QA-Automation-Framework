package N_POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage_N {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;


    public BasePage_N(WebDriver givenDriver){
        driver =givenDriver;
        wait   =new WebDriverWait(driver, Duration.ofSeconds(5));
        actions=new Actions(driver);
    }
}