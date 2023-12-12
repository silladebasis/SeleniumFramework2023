package pages;

import org.openqa.selenium.By;
import static utils.CommonFunctions.clickElement;
public class CartPage {
    private final By view_cart_btn = By.xpath("//u[normalize-space()='View Cart']");
    private final By place_order_btn = By.xpath("//a[normalize-space()='Proceed To Checkout']");
    public CartPage clickOnViewCart(){
        clickElement(view_cart_btn);
        //getDriver().findElement(view_cart_btn).click();
        return this;
    }
    public CartPage clickOnPlaceOrderBtn(){
        clickElement(place_order_btn);
        //getDriver().findElement(place_order_btn).click();
        return this;
    }
}
