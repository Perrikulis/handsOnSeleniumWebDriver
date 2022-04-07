package Steps;

import Pages.MyStoreHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyStoreHomeSteps extends BaseSteps {

    //Este _webDriver viene de _webDriver en BaseSteps.java
    MyStoreHomePage _myStoreHomePage = new MyStoreHomePage(_webDriver);

    //WebDriver se va a recibir desde MyStoreHomeTests
    public MyStoreHomeSteps(WebDriver webDriver) {
        super(webDriver);
    }

    public String getMenuItemTitle(String menuOption){
        WebElement menuItem = _myStoreHomePage.getMenuItem(menuOption);

        String titleAttribute = menuItem.getAttribute("title");
        System.out.println("Title attribute: " + titleAttribute);
        String titleText = menuItem.getText();
        System.out.println("Texto entre etiquetas HTML: " + titleText);
        String titleTagName = menuItem.getTagName();
        System.out.println("Nombre de etiqueta HTML: " + titleTagName);

        return titleAttribute;
    }

}
