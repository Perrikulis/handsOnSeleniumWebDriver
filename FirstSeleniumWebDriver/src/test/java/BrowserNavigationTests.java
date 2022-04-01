import enums.WebDriverType;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserNavigationTests extends BaseTest {
    final String url = "https://www.google.com";
    final String urlMyStore = "http://www.automationpractice.com/index.php";
    private WebDriver _childWevDriver = webDriver;


    @Test
    public void testOpoenBrowser() {
        //metodo para abrir URL con Selenium WebDriver
        _childWevDriver.get(url);
        _childWevDriver.manage().window().maximize();
        _childWevDriver.get("https://www.guru99.com");


        String title = _childWevDriver.getTitle();
        System.out.println(title);
        title.equals("My Store");

    }

    @Test
    public void testGetPageTitle() {
        _childWevDriver.get(urlMyStore);
        String pageTitleActual = _childWevDriver.getTitle();
        System.out.println("Page title is: " + pageTitleActual);
        //El requerimiento es que el titulo sera My Store
        String pageTitleExpected = "My Store";
        Assert.assertEquals(pageTitleActual, pageTitleExpected);
    }

    @Test
    public void testGetPageTitleNegative() {
        _childWevDriver.get(urlMyStore);
        String pageTitleActual = _childWevDriver.getTitle();
        System.out.println("Page title is: " + pageTitleActual);
        //El requerimiento es que el titulo sera My Store
        String pageTitleNOExpected = " My Store* ";
        Assert.assertNotEquals(pageTitleActual, pageTitleNOExpected);
    }

    @Test
    public void testApplicationURL() {
        _childWevDriver.get(urlMyStore);
        String actualtURL = _childWevDriver.getCurrentUrl();
        System.out.println("Page current URL is: " + actualtURL);
        Assert.assertTrue(urlMyStore.equals(actualtURL), "Expected URL and Current URL are not matching.");

    }

    @Test
    public void testApplicationURLNegativo() {
        _childWevDriver.get(urlMyStore);
        String actualtURL = _childWevDriver.getCurrentUrl();
        System.out.println("Page current URL is: " + actualtURL);
        Assert.assertFalse((urlMyStore.equals(actualtURL)), "Expected URL and Current URL are matching.");

    }



}
