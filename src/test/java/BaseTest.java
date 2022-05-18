import enums.WebDriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    //Comienzo: Declarando variables Globales

    private String _chromeDriverPath = "/Users/jcanalesp/Documents/WebDrivers/chromedriver";
    private String _fireFoxDriverPath = "/Users/jcanalesp/Documents/WebDrivers/geckodriver";
    private String _operaDriverPath = "/Users/jcanalesp/Documents/WebDrivers/operaDriver";
    //En Windows el path debe empezar con C: y terminar el chromedriver.exe

    public WebDriver webDriver = getWebDriver(WebDriverType.CHROME);

    private WebDriverType _webDriverType = WebDriverType.CHROME;

    //Fin Variables Globales

    private WebDriver getWebDriver(WebDriverType webDriverType) {
        this._webDriverType = webDriverType;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        //Start SWITCH
        switch (webDriverType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", _chromeDriverPath);
                ChromeOptions options = new ChromeOptions();
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
                //Will not work for now!!!!!!
                System.setProperty("webdriver.opera.driver", _operaDriverPath);
                webDriver = new OperaDriver();
                break;
        } // Ends SWITCH

        //System.out.println("El WebDriver tipo " + webDriverType + " se ha inicializado con exito.");
        return webDriver;
    }

    //Annotations
    @BeforeTest
    public void beforeTest() {
        //System.out.println("Before test en Clase BaseTest.java");
        webDriver.manage().window().maximize();

        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterTest
    public void afterTest() {
        //System.out.println("After test en Clase BaseTest.java");
        //Muere WebDriver
        webDriver.quit();
    }

}
