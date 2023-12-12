package pages;

import org.openqa.selenium.By;
import static driver.DriverManager.getDriver;
import static utils.CommonFunctions.clickElement;
import static utils.CommonFunctions.waitForElement;
public class ProductDetailsPage {
    private final By add_to_cart_btn = By.xpath("//button[normalize-space()='Add to cart']");
    private final By product_added_cart_msg = By.xpath("(//*[@class='modal-body']/p)[1]");
    public ProductDetailsPage clickOnAddToCart(){
        clickElement(add_to_cart_btn);
        //getDriver().findElement(add_to_cart_btn).click();
        return this;
    }
    public String verifyProductAddedToCartMsg(){
        waitForElement(product_added_cart_msg);
        return getDriver().findElement(product_added_cart_msg).getText();
    }
}
