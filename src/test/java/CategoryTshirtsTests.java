import Steps.CategoryTshirtsSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CategoryTshirtsTests extends BaseTest{
    CategoryTshirtsSteps _categoryTshirtsSteps = new CategoryTshirtsSteps(webDriver);

    @Test(description = "Tests para probar la categoria T-shirts del proyecto final")
    public void testSR1012() {
        //Step 1: Abrir My Store
        _categoryTshirtsSteps.openMyStore();
        //Step 2: Click in Women Menu
        _categoryTshirtsSteps.clickTshirtsMenu();
        //Step 3: Validate Women category URL
        Assert.assertTrue(_categoryTshirtsSteps.verifyURLCategoryTshirts());
        //Step 4: Validate Women Banner
        Assert.assertTrue(_categoryTshirtsSteps.verifyTshirtsBanner());
        //Step 5: Validate Women Text
        Assert.assertEquals(_categoryTshirtsSteps.verifyTshirtsText(), "The must have of your wardrobe, take a look at our different colors,");
        //Step 6: Validate Women Text 2
        Assert.assertEquals(_categoryTshirtsSteps.verifyTshirtsText2(), "shapes and style of our collection!");
        //Step 7: Validate Women 7 products
        Assert.assertEquals(_categoryTshirtsSteps.verifyTshirtsResults(), "There is 1 product.");
    }

}