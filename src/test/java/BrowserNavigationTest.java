import enums.WebDriverType;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserNavigationTest extends BaseTest {

    final String url = "https://www.google.com";
    final String urlMyStore = "http://automationpractice.com/index.php";
    private WebDriver _childWebDriver = webDriver;




    @Test
    public void  testOpenBrowser(){
        //Metodo para abrir URL con Selenium WebDriver
        _childWebDriver.get(url);
        _childWebDriver.manage().window().maximize();

    }

    @Test
    public void testGetPageTitle() {
        _childWebDriver.get(urlMyStore);
        String pageTitleActual = _childWebDriver.getTitle();
        //El requerimiento es que el título sea MyStore
        String pageTitleExpected = "My Store";
        System.out.println("Page Title is: "+pageTitleActual);
        Assert.assertEquals(pageTitleExpected, pageTitleActual);
        //Assert.assertNotEquals(pageTitleExpected, pageTitleActual);

    }

    @Test
    public void testApplicationURL(){

        _childWebDriver.get(urlMyStore);
        String actualURL = _childWebDriver.getCurrentUrl();
        System.out.println ("Page current URL is: "+actualURL);
        Assert.assertTrue(urlMyStore.equals(actualURL));
    }

    @Test
    public void testApplicationURLNegative(){

        _childWebDriver.get(urlMyStore);
        String actualURL = _childWebDriver.getCurrentUrl();
        System.out.println ("Page current URL is: "+actualURL+"?");

        Boolean assertFalseTest = urlMyStore.equals(actualURL);
        System.out.println(urlMyStore + " equals " + actualURL + "? :" + assertFalseTest);
        Assert.assertFalse(urlMyStore.equals(actualURL+"?"));

    }



} // Final de la clase
