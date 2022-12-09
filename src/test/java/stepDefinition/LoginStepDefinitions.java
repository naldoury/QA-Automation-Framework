package stepDefinition;

import POM.pages.HomePage;
import POM.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginStepDefinitions {

    WebDriver driver;
//    WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));

    @Before
    public void iOpenBrowser() {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver= new ChromeDriver();
    }

    @After
    public void iCloseTheBrowser(){
            driver.quit();
    }

    @Given("I Open Login Page")
    public void iOpenLoginPage() {
        driver.get("http://bbb.testpro.io");
    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }

    @And("I submit")
    public void iSubmit() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmitBtn();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        HomePage homepage = new HomePage(driver);
        By avatar = By.cssSelector("img.avatar");
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(avatar));
 //       Assert.assertTrue(homepage.getUserAvatar().isDisplayed());
          Assert.assertTrue(driver.findElement(avatar).isDisplayed());
    }
}
