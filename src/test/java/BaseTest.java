import enums.WebDriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.File;

public class BaseTest {

/*   public void recibeDiaDeLaSemana(DaysOfWeek daysOfWeek){

    }

    public void ejemplo(){
       recibeDiaDeLaSemana(DaysOfWeek.DOMINGO);
    }
*/

    //Declarando Variables Globales
    private String _chromeDriverPath = "C:\\DChrome\\chromedriver.exe";
    private String _firefoxDriverPath = "C:\\DChrome\\geckodriver.exe";
    private String _operaDriverPath = "C:\\DChrome\\geckodriver.exe";

    public WebDriver webDriver = getWebDriver(WebDriverType.CHROME);

    private WebDriverType _webDriverType = WebDriverType.CHROME;

    //Fin Variables Globales

    //Creación de Métodos
    public WebDriver getWebDriver(WebDriverType webDriverType){
        this._webDriverType = webDriverType;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //Start SWITCH
        switch (webDriverType){
            case CHROME:
                System.setProperty("webdriver.chrome.driver",_chromeDriverPath);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                //opciones de chrome se cargan en objeto desiredCapabilities donde se indica que
                //se use chrome con las opciones especificadas
                desiredCapabilities.setCapability(ChromeOptions.CAPABILITY,options);
                options.merge(desiredCapabilities);
                webDriver = new ChromeDriver(options);
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", _firefoxDriverPath);
                webDriver = new FirefoxDriver();
                break;
            case OPERA:
                //Don't work for now
                System.setProperty("webdriver.opera.driver", _operaDriverPath);
                webDriver = new OperaDriver();
                break;
        } //END SWITCH

        System.out.println("El WebDriver tipo "+ webDriverType + " se ha inicializado con éxito.");
        return webDriver;
    }

    //Annotations
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before test en Clase BeforeTest.java");
        //webDriver = getWebDriver(WebDriverType.CHROME);
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After test en Clase BeforeTest.java");
        //Se muere el WebDriver

        webDriver.quit();  //Cierra el navegador
        //webDriver.close(); //Cierra la pestaña
    }

}
