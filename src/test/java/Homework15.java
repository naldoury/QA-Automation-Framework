import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework15 {

    @Test
    public static void Search()throws InterruptedException
    {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);



        WebElement emailField = driver.findElement(new By.ByCssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("demo@class.com");


        WebElement passwordField = driver.findElement(new By.ByCssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement submitButton = driver.findElement(new By.ByCssSelector("[type='submit']"));
        submitButton.submit();
        WebElement avatarIcon = driver.findElement( By.className("avatar"));
        Assert.assertTrue(avatarIcon.isDisplayed());

        WebElement songsList = driver.findElement( By.className("songs"));
        Assert.assertTrue(songsList.isDisplayed());
        songsList.click();


        WebElement songsTitle = driver.findElement( By.className("title"));
        String expectedSongName = "pluto";
        String songName = driver.findElement( By.className("title")).getText();
        if(expectedSongName.equals(songName))
            System.out.println("Yes, pluto song is on the list");
        else
            System.out.println("pluto song is not found!");


        Thread.sleep(3000);
        driver.quit();
    }


}
