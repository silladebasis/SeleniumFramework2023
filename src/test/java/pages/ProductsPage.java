package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import static driver.DriverManager.getDriver;
import static utils.CommonFunctions.*;
public class ProductsPage {
    private final By search_product_txt = By.id("search_product");
    private final By search_btn = By.id("submit_search");
    private final By search_products_results = By.cssSelector(".features_items div div.product-image-wrapper");
    private final By view_cart_btn = By.xpath("//a[normalize-space()='View Product']");
    public void searchProduct(String productName){
        try {
            enterText(search_product_txt,productName);
            clickElement(search_btn);
            //getDriver().findElement(search_product_txt).sendKeys(productName);
            //getDriver().findElement(search_btn).click();
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
    public boolean isSearchProductDisplayed(){
        waitForElement(search_product_txt);
        return getDriver().findElement(search_product_txt).isDisplayed();
    }
    public long getProductCount(){
        return getDriver().findElements(search_products_results).stream().count();
    }
    public void clickOnViewCart(){
        waitForElement(search_product_txt);
        clickElement(view_cart_btn);
        //getDriver().findElement(view_cart_btn).click();
    }
}
