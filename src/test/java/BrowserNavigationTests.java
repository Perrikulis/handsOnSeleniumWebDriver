import enums.WebDriverType;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserNavigationTests extends BaseTest {
    final String url = "https://www.google.com";
    final String urlMyStore = "http://automationpractice.com/index.php";
    private WebDriver _childWebDriver = webDriver;

    //Localizadores o Selectors
    final String logoCSSLocatorFalse = "div.header_logo";
    final String logoCSSLocator = "div#header_logo";

    @Test
    public void testOpenBrowser() {
        //Metodo para abrir URL con Selenium WebDriver
        _childWebDriver.get(url);
        _childWebDriver.manage().window().maximize();
    }

    @Test
    public void testGetPageTitle() {
        _childWebDriver.get(urlMyStore);
        String pageTitleActual = _childWebDriver.getTitle();
        //El requermiento es que el titulo sea My Store
        String pageTitleExpected = "My Store";
        System.out.println("Page title is: " + pageTitleActual);
        Assert.assertEquals(pageTitleActual, pageTitleExpected);
    }

    @Test
    public void testGetPageTitleNegative() {
        _childWebDriver.get(urlMyStore);
        String pageTitleActual = _childWebDriver.getTitle();
        //El requermiento es que el titulo sea My Store
        String pageTitleNotExpected = "_My Store_";
        System.out.println("Page title is: " + pageTitleActual);
        Assert.assertNotEquals(pageTitleActual, pageTitleNotExpected);
    }

    @Test
    public void testApplicationURL() {
        _childWebDriver.get(urlMyStore);
        String actualURL = _childWebDriver.getCurrentUrl();
        System.out.println("Page current URL is: " + actualURL);
        Assert.assertTrue(urlMyStore.equals(actualURL),
                "Expected URL and Current URL are not matching.");
    }

    @Test
    public void testApplicationURLNegative() {
        _childWebDriver.get(urlMyStore);
        String actualURL = _childWebDriver.getCurrentUrl() + "+";
        System.out.println("Page current URL is: " + actualURL);
        Boolean assertFalseTest = urlMyStore.equals(actualURL);
        System.out.println(urlMyStore + " equals " + actualURL + "? :" + assertFalseTest);
        Assert.assertFalse(urlMyStore.equals(actualURL+ "?"),
                "Testing assert false");
    }

    @Test
    public void testSearchFirstElement() {
        openMyStore();
        WebElement logo = _childWebDriver.findElement(By.cssSelector(logoCSSLocator));
        System.out.println(logo.isDisplayed());
    }

    @Test
    public void testManejoDeException() {
        openMyStore();
        try {
            WebElement logo = _childWebDriver.findElement(By.cssSelector(logoCSSLocatorFalse));
            System.out.println("Codigo try: " + logo.isDisplayed());
        } catch (NoSuchElementException logoNoLocalizado) {
            System.out.println("Catch logoNoLocalizado: El localizador " + logoCSSLocatorFalse + " no funciona.");
            WebElement logo = _childWebDriver.findElement(By.cssSelector(logoCSSLocator));
            System.out.println("El logo se esta mostrando: " + logo.isDisplayed());
        }
    }

    private void openMyStore() {
        _childWebDriver.get(urlMyStore);
        System.out.println("El navegador ha abierto la URL: " + urlMyStore);
    }
}
