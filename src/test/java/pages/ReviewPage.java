package pages;

import org.openqa.selenium.By;
import static driver.DriverManager.getDriver;
import static utils.CommonFunctions.clickElement;

public class ReviewPage {
    private final By review_text = By.xpath("(//div[@class='step-one']/h2)[2]");
    private final By place_order_btn = By.xpath("//a[normalize-space()='Place Order']");
    public String getReviewText(){
        return getDriver().findElement(review_text).getText();
    }
    public void clickOnPlaceOrder(){
        clickElement(place_order_btn);
        //getDriver().findElement(place_order_btn).click();
    }
}
