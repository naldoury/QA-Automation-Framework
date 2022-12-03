import N_POM.pages.HomePage_N;
import N_POM.pages.LoginPage_N;
import org.testng.Assert;
import org.testng.annotations.Test;

public class naldoury_Homework25 extends BaseTest_N{

//    WebDriver driver;
//    WebDriverWait wait;

@Test
    public void LoginValidEmailPasswordVerification(){
        LoginPage_N loginPage = new LoginPage_N(getDriver());
        HomePage_N homePage   = new HomePage_N(getDriver());
        loginPage.login();
//        loginPage.provideEmail("demo@class.com");
//        loginPage.providePassword("te$t$tudent");
//        loginPage.clickSubmitButton();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

        }

    @Test
    public void LoginvalidEmailPasswordVerificationtest2(){
        LoginPage_N loginPage = new LoginPage_N(getDriver());
        HomePage_N homePage   = new HomePage_N(getDriver());
//        loginPage.login();
        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmitButton();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }

}



