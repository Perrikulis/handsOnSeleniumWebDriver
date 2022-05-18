import enums.WebDriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    //Comienzo: Declarando variables Globales
    private String _chromeDriverPath = "C:\\Users\\cynth\\Documents\\WebDriver\\chromedriver.exe";
    private String _fireFoxDriverPath = "/Users/jxr20920/Downloads/geckodriver";
    private String _operaDriverPath = "/Users/jxr20920/Downloads/operaDriver";
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

        System.out.println("El WebDriver tipo " + webDriverType + " se ha inicializado con exito.");
        return webDriver;
    }

    //Annotations
    @BeforeTest
    public void beforeTest() {
        System.out.println("Before test en Clase BaseTest.java");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After test en Clase BaseTest.java");
        //Muere WebDriver
        webDriver.quit();
    }

    public String getPropertyValue(String nameOfProperty) throws IOException {
        Properties demoQAProperties = new Properties();
        InputStream propertiesFilePath = new FileInputStream("equipo1.properties");
        demoQAProperties.load(propertiesFilePath);
        String value = demoQAProperties.getProperty(nameOfProperty);
        propertiesFilePath.close();
        return value;
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        webDriver.quit();
    }

    @BeforeGroups(groups = {"menuTestGroup"})
    public void setUp() throws IOException {
        System.out.println("Ejecutando el Before Group");
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.get(getPropertyValue("HOME_MY_STORE_URL"));
        webDriver.manage().window().maximize();
        Reporter.log("Actual URL: " + webDriver.getCurrentUrl());
    }
}