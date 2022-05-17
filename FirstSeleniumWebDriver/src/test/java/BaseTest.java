import enums.WebDriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {
    //C://Windows//chromedriver.exe
    //C://Windows//geckodriver.exe
    //C:/Users/mario/Documents/chromedriver.exe
    //comienzo mis variables globales
    private String _chromeDriverPath = "C:\\Users\\mario\\Desktop\\Chromedriver\\chromedriver.exe";
    private String _fireFoxDriverPath = "C:\\Users\\mario\\Desktop\\Chromedriver\\geckodriver.exe";
    private String _operaDriverPath = "C:\\Windows\\operadriver.exe";

    public WebDriver webDriver = getWebDriver(WebDriverType.CHROME);
    private WebDriverType _webDriverType = WebDriverType.CHROME;


    private WebDriver getChromeWebDriver() {
        System.setProperty("webdriver.chrome.driver", _chromeDriverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        chromeOptions.merge(desiredCapabilities);
        return new ChromeDriver(chromeOptions);
    }

    public String getPropertyValue(String nameOfProperty) throws IOException {
        Properties demoQAProperties = new Properties();
        InputStream propertiesFilePath = new FileInputStream("values.properties");
        demoQAProperties.load(propertiesFilePath);
        String propertyValue = demoQAProperties.getProperty(nameOfProperty);
        propertiesFilePath.close();
        return propertyValue;
    }



    //fin variables globales
    public WebDriver getWebDriver(WebDriverType webDriverType) {
        this._webDriverType = webDriverType;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        //Start switch
        switch (webDriverType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", _chromeDriverPath);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--Incognito");
                desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
                options.merge(desiredCapabilities);

                webDriver = new ChromeDriver(options);
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", _fireFoxDriverPath);
                webDriver = new FirefoxDriver();
                break;
            case OPERA:
                System.setProperty("webdriver.opera.driver", _operaDriverPath);
                webDriver = new OperaDriver();
                break;
        }//end switch

        System.out.println("El WebDriver tipo " + webDriverType + " se ha inicializado con exito. ");
        return webDriver;

    }

    @BeforeTest
    public void beforeTest() {

        System.out.println("Before test en Clase BaseTes.java");

        //   webDriver = getWebDriver(WebDriverType.CHROME);

    }

  /*  @AfterTest
    public void afterTest() {
        System.out.println("afterTest test en Clase BaseTes.java");
        webDriver.quit();

    }*/

}