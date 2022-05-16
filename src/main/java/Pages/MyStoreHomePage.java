package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MyStoreHomePage extends BasePage {
    WebDriver webDriverMyStoreHome;

    @FindBy(how = How.CSS, using = "ul.sf-menu>li>a")
    private List<WebElement> menuList;

    @FindBy(how = How.XPATH, using = "//ul[contains(@class,\"sf-menu clearfix menu-content sf-js-enabled sf-arrows\")]/li/a[contains(text(),\"Dresses\") and contains(@class,\"sf-with-ul\")]")
    private WebElement dressesMenuElement;

    public MyStoreHomePage(WebDriver _webDriverMyStoreHome) {
        this.webDriverMyStoreHome = _webDriverMyStoreHome;
    }

    //Este metodo se manda a llamar desde MyStoreHomeSteps
    public List<WebElement> getMenuList() {
        return menuList;
    }

    public WebElement getDressesMenuElement(){
        return dressesMenuElement;
    }

    //Este metodo se manda a llamar desde MyStoreHomeSteps
    public WebElement getMenuItem(String menuItemName) {
        WebElement itemToReturn = getMenuList().get(0);
        for(WebElement item : getMenuList()) {
            String title = item.getAttribute("title");
            System.out.println("Current item is: " + title);
            if (title.equals(menuItemName)) {
                itemToReturn =  item;
                System.out.println("option found: " + title);
                break;
            }
        }
        return itemToReturn;
    }

}
