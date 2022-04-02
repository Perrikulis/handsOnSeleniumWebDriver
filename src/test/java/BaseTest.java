import enums.WebDriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

public class BaseTest {


    // Declarando variables globales
    private String _chromeDriverPath = "C:\\Users/SWMX/Documents/chromedriver_win32/chromedriver.exe";
    private String _fireFoxDriverPath = "C:\\Users\\SWMX\\Documents\\geckodriver-v0.30.0-win64\\geckodriver.exe";
    private String _oepraDriverPath = "C:\\Users\\SWMX\\Documents\\geckodriver-v0.30.0-win64\\geckodriver.exe";

    public WebDriver webDriver = getWebDriver(WebDriverType.CHROME);

    private WebDriverType _webDriverType = WebDriverType.CHROME;

    // Fin Variables Globales

    public WebDriver getWebDriver(WebDriverType webDriverType) {
        this._webDriverType = webDriverType;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        //Start SWITCH
        switch (webDriverType){
            case CHROME:
                System.setProperty("webdriver.chrome.driver", _chromeDriverPath);
                ChromeOptions  options = new ChromeOptions();
                options.addArguments("--incognito");
                desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
                options.merge(desiredCapabilities);
                webDriver = new ChromeDriver(options);
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", _fireFoxDriverPath);
                webDriver = new FirefoxDriver();
                break;
            case OPERA:
                // Todavía no funciona
                System.setProperty("webdriver.opera.driver", _oepraDriverPath);
                webDriver = new OperaDriver();
                break;

        }// Ends SWITCH

        System.out.println("El WebDriver tipo " + webDriverType + " se ha inicializado con exito. ");
        return webDriver;

    } // ends metodo public WebDriver

    // Annotations
    @BeforeTest

    public void beforeTest(){
        System.out.println("Before test en Class BaseTest.java");
        //webDriver = getWebDriver(WebDriverType.CHROME);

    }

    @AfterTest
    public void afterTest(){
        System.out.println("After test en Class BaseTest.java");
        // muere el web driver
        webDriver.quit();
    }

}