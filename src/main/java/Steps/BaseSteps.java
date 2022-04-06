package Steps;

import org.openqa.selenium.WebDriver;

public class BaseSteps {

    WebDriver _webDriver;
    final String urlMyStore = "http://automationpractice.com/index.php";

    public BaseSteps(WebDriver _webDriver) {
        System.out.println("Constructor del BaseSteps.java");
        this._webDriver = _webDriver;
    }

    public void openMyStore(){
        System.out.println("openMyStore método en BaseSteps.java");
        _webDriver.get(urlMyStore);
        System.out.println("El navegador ha abierto la URL " + urlMyStore);
    }
}
