import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BaseTest_N {

    WebDriver driver;
    String url;
    WebDriverWait wait;
    Actions actions;

    static ThreadLocal<WebDriver> threadDriver;


    @BeforeSuite
    public static void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
    }

    @BeforeMethod
    // Send a parameter for 'baseURL' specified in XML
    @Parameters({"baseURL"})
    // Make baseURL parameter optional, if it is null, then set it to something)
    public void launchBrowser(@Optional String baseURL) throws MalformedURLException {
        if (baseURL == null)

            baseURL ="https://bbb.testpro.io";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
//        driver = pickAbrowser(System.getProperty("theBrowser"));
        threadDriver = new ThreadLocal<>();
        driver = pickAbrowser(System.getProperty("browser"));
        threadDriver.set(driver);

//        actions = new Actions(getDriver());
        wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
        // Wait for an element to show up for max of X seconds
        // implicitlyWait(Duration.ofSeconds(60) will wait for UP to 60 seconds
        // if element comes up after 1 second, it will move on
//        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        getDriver().manage().window().maximize();
        // thread.sleep(60000) -- will wait 60s always
        url = baseURL;
        getDriver().get(url);

    }
    public  WebDriver getDriver(){
        return threadDriver.get();
    }
    private WebDriver pickAbrowser(String theBrowser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURI = "http://10.0.0.45:4444";
//        getDriver().get(url);

        switch (theBrowser){

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                return driver = new FirefoxDriver();

            case "safari":
                return driver = new SafariDriver();

            case "grid-firefox":
                caps.setCapability("browserName","firefox" );
                return driver = new RemoteWebDriver(URI.create(gridURI).toURL(),caps);

            case "grid-chrome":
                caps.setCapability("browserName","chrome" );
                return driver = new RemoteWebDriver(URI.create(gridURI).toURL(),caps);

            default:
                return driver = new ChromeDriver();

        }
    }

    @AfterMethod
    public void tearDownBrowser() {
        getDriver().quit();
        threadDriver.remove();
    }
    public void clickSubmitBtn() {
        WebElement submitButton = getDriver().findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
    }
    public void provideEmail(String email) {
        WebElement emailField = getDriver().findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = getDriver().findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);

    }

    @DataProvider(name="invalidCredentials")
    public static Object[][] getCredentials(){

        return new Object[][] {
                {"invalid@class.com", "invalidPass"},
                {"d@class.com", ""},
                {"", ""}
        };
    }

    public void login(){
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }
}
