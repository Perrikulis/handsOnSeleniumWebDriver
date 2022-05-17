package Steps;

import Pages.MyStoreHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyStoreHomeSteps extends BaseSteps{
    final  String _menuItemPartialLInkLocator = "Dresses";
    //Este :weDreiver viene de _weDriver BaseSteps.java
    MyStoreHomePage _myStoreHomePage = new MyStoreHomePage(_webDriver);

    //
    public MyStoreHomeSteps(WebDriver webDriver) {
        super(webDriver);
    }

    public String getMenuItemTitle(String option) {
        WebElement menuItem =  _myStoreHomePage.getMenuItem(_menuItemPartialLInkLocator);
        String titleAttrubute = menuItem.getAttribute("title");
        System.out.println("Title atribute: " + titleAttrubute);
        String titleText = menuItem.getText();
        System.out.println("Texto entre etiquetas HTML: " + titleText);
        String titleTagName = menuItem.getTagName();
        System.out.println("Nombre de Etiqueta HTML: " + titleTagName);
        return titleAttrubute;
    }


}

