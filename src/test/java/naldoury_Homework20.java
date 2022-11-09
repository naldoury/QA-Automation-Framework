import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class naldoury_Homework20 extends BaseTest {
    @Test
        public void deletePlaylist() throws InterruptedException {
//        1-lgin
            login();
//        2-selectPlaylist
            selectPlaylist();
//        3-deleteplaylist
            deleteAPlaylist();
//        4-assert playlist deleted
           Assert.assertTrue(playlistWasDeletedMessage().contains("Deleted playlist"));
    }
    public void selectPlaylist() {
            WebElement selectAPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
            selectAPlaylist.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        }
        private void deleteAPlaylist() throws InterruptedException{
        WebElement deletethisPlaylist = driver.findElement(new By.ByCssSelector(".btn-delete-playlist"));
        deletethisPlaylist.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
}
        private String playlistWasDeletedMessage()  {
            return driver.findElement(By.cssSelector("div.success.show")).getText();
    }

    }




