package Steps;

import Pages.MyStoreHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class MyStoreHomeSteps extends BaseSteps {

    //Este _webDriver viene de _webDriver en BaseSteps.java
    //MyStoreHomePage _myStoreHomePage = new MyStoreHomePage(_webDriver);
    MyStoreHomePage _myStoreHomePage = PageFactory.initElements(_webDriver, MyStoreHomePage.class);
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

    public boolean dressesMenuItemIsDisplayed(){
        Reporter.log("Dresses menu is displayed: " + _myStoreHomePage.getDressesMenuElement().isDisplayed() + "<br>");
        return _myStoreHomePage.getDressesMenuElement().isDisplayed();
    }

    public void clickOnDressesMenuItem(){
        if (dressesMenuItemIsDisplayed()){
            Reporter.log("Click on Dresses Menu"+ "<br>");
            _myStoreHomePage.getDressesMenuElement().click();
        }
    }

}
