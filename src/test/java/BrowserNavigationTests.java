import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserNavigationTests extends BaseTest {
    final String url = "https://www.google.com";
    final String urlMyStore = "http://automationpractice.com/index.php";
    private WebDriver _childWebDriver = webDriver;

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
}
