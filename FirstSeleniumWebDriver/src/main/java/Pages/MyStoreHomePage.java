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

    //Este metodo se manda llamar desde MyStoreHomePage
    public List<WebElement> getMenuList() {
        List<WebElement> ListaMenu = webDriverMyStoreHome.findElements(By.cssSelector(menuListClassSelector));
        return ListaMenu;
    }

    //Este es el metodo se manda a llamar des myStoreHomeSteps
    public WebElement getMenuItem(String menuITemName) {
        WebElement itemToReturn = getMenuList().get(0);
        for (WebElement item : getMenuList()) {
            String title = item.getAttribute("title");
            System.out.println("current item is: " + title);
            if (title.equals(menuITemName)) {
                itemToReturn = item;
                System.out.println("option found: " + title );
                break;
            }

        }

        return itemToReturn;
    }
}
