import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 {

    @Test
    public static void newPlayList() throws InterruptedException
    {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);


        WebElement emailField = driver.findElement( By.xpath("//*[@type='email']"));
        emailField.click();
        emailField.sendKeys("demo@class.com");


        WebElement passwordField = driver.findElement( By.xpath("//*[@type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement submitButton = driver.findElement( By.xpath("//*[@type='submit']"));
        submitButton.submit();
        //WebElement avatarIcon = driver.findElement( By.className("avatar"));
        //can u pls tell me what is wrong in this? xpath avatar
        WebElement avatarIcon = driver.findElement( By.xpath("//img[contains(@alt,'Avatar of')]"));
        Assert.assertTrue(avatarIcon.isDisplayed());

        Thread.sleep(2000);
        WebElement addNewPlayList = driver.findElement(By.xpath("//*[@data-testid = 'sidebar-create-playlist-btn']"));
        addNewPlayList.click();

        WebElement NewPlayList = driver.findElement(By.xpath("//*[@data-testid = 'playlist-context-menu-create-simple']"));
        NewPlayList.click();
      //  Thread.sleep(2000);

        WebElement myPlaylist = driver.findElement(By.xpath("//*[@id=\"playlists\"]/form/input"));
        myPlaylist.click();
        myPlaylist.sendKeys("myPlaylist");
        myPlaylist.sendKeys(Keys.ENTER);
        //myPlaylist.click();

        Thread.sleep(3000);
        WebElement chkmyPlaylist = driver.findElement(By.xpath("//a[contains(text(),'myPlaylist')]"
        ));
        Assert.assertTrue(chkmyPlaylist.isDisplayed());
        Thread.sleep(2000);
        driver.quit();


    }
}





