
import Steps.CategoryWomenSteps;
import org.testng.annotations.Test;
import org.testng.Assert;


public class CategoryWomenTests extends BaseTest{
    CategoryWomenSteps _categoryWomenSteps = new CategoryWomenSteps(webDriver);

    @Test(description = "Tests para probar la categoria WOMEN del proyecto final")
    public void testSR1010(){
        //Step 1: Abrir My Store
        _categoryWomenSteps.openMyStore();
        //Step 2: Click in Women Menu
        _categoryWomenSteps.clickWomenMenu();
        //Step 3: Validate Women category URL
        Assert.assertTrue(_categoryWomenSteps.verifyURLCategoryWomen());
        //Step 4: Validate Women Banner
        Assert.assertTrue(_categoryWomenSteps.verifyWomenBanner());
        //Step 5: Validate Women Text
        Assert.assertEquals(_categoryWomenSteps.verifyWomenText(),"This category includes all the basics of your wardrobe and much more:");
        //Step 6: Validate Women Text 2
        Assert.assertEquals(_categoryWomenSteps.verifyWomenText2(),"shoes, accessories, printed t-shirts, feminine dresses, women's jeans!");
        //Step 7: Validate Women 7 products
        Assert.assertEquals(_categoryWomenSteps.verifyWomenResults(),"There are 7 products.");
    }
}