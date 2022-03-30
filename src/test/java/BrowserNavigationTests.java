import enums.WebDriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class BrowserNavigationTests extends BaseTest {
    final String url = "https://www.google.com";
    private WebDriver _childWebDriver = webDriver;

    @Test
    public void testOpenBrowser() {
        //Metodo para abrir URL con Selenium WebDriver
        _childWebDriver.get(url);
        _childWebDriver.manage().window().maximize();
    }
}
