import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

//naldoury_Homework21
public class naldoury_Homework21 extends BaseTest {
    String playListName = "mySongs";
    @Test
    public void renamePlaylist() throws InterruptedException {

//    1-login
        login();
//    2-select, rename Playlist and Assert
        DoubleClickChoosePlayList();
        renamePlayList();
        Assert.assertTrue(DoesPlayListExist());
    }
       private Boolean DoesPlayListExist() {
        WebElement renamedPlaylistElement =  driver.findElement(By.xpath("//a[contains(text(),'"+playListName+"')]"));
        return  renamedPlaylistElement.isDisplayed();
    }

    private void DoubleClickChoosePlayList() {

        WebElement playListElement = driver.findElement(new By.ByCssSelector(".playlist:nth-child(3)"));
        wait.until(ExpectedConditions.visibilityOfAllElements(playListElement));
        actions.doubleClick(playListElement).perform();
    }
    private void renamePlayList(){
        WebElement renameplaylistfield = driver.findElement(new By.ByCssSelector("input[name='name']"));
        renameplaylistfield.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        renameplaylistfield.sendKeys(playListName);
        renameplaylistfield.sendKeys(Keys.ENTER);
    }
}






