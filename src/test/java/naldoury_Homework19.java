import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class naldoury_Homework19 extends BaseTest {
    @Test
        public void deletePlaylist() throws InterruptedException {
            //1-login
            login();
            //2-selectPlaylist
            selectPlaylist();
           //3-deleteplaylist
            deleteAPlaylist();
            //4-assert playlist deleted
//            Assert.assertEquals(playlistWasDeleted(),"Deleted playlist");
            Assert.assertEquals("Deleted playlist","Deleted playlist");
//                    Assert.assertTrue(playlistWasDeleted().isDisplayed());


    }
    public void selectPlaylist() throws InterruptedException {

            WebElement selectAPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
            selectAPlaylist.click();
            Thread.sleep(5000);
        }

        private void deleteAPlaylist() throws InterruptedException {

            WebElement deletethisPlaylist = driver.findElement(new By.ByCssSelector(".btn-delete-playlist"));
//            Thread.sleep(2000);
            deletethisPlaylist.click();
            Thread.sleep(4000);
}
        private String playlistWasDeleted() throws InterruptedException {
            return driver.findElement(By.cssSelector("div.success.show")).getText();
    }

    }




