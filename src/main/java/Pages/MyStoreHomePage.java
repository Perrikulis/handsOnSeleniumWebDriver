package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyStoreHomePage extends BasePage {
    WebDriver webDriverMyStoreHome;
    private final String menuListClassSelector = "ul.sf-menu>li>a";

    public MyStoreHomePage(WebDriver _webDriverMyStoreHome) {
        this.webDriverMyStoreHome = _webDriverMyStoreHome;
    }

    //Este metodo se manda a llamar desde MyStoreHomeSteps
    public List<WebElement> getMenuList() {
        List<WebElement> listaMenu = webDriverMyStoreHome.findElements(By.cssSelector(menuListClassSelector));
        return listaMenu;
    }

    //Este metodo se manda a llamar desde MyStoreHomeSteps
    public WebElement getMenuItem(String menuItemName) {
        WebElement itemToReturn = getMenuList().get(0);
        for(WebElement item : getMenuList()) {
            String title = item.getAttribute("title");
            System.out.println("Current selected item is: " + title);
            if (title.equals(menuItemName)) {
                itemToReturn =  item;
                System.out.println("option found: " + title);
                break;
            }
        }
        return itemToReturn;
    }

}
