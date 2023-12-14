package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import static driver.DriverManager.getDriver;
import static utils.CommonFunctions.clickElement;
import static utils.CommonFunctions.getElement;

public class ReviewPage {
    private final By review_text = By.xpath("(//div[@class='step-one']/h2)[2]");
    private final By place_order_btn = By.xpath("//a[normalize-space()='Place Order']");
    public String getReviewText(){
        return getDriver().findElement(review_text).getText();
    }
    public void clickOnPlaceOrder(){
       JavascriptExecutor js = (JavascriptExecutor)getDriver();
       js.executeScript("arguments[0].scrollIntoView(true);",getElement(place_order_btn));
        clickElement(place_order_btn);
        //getDriver().findElement(place_order_btn).click();
    }
}
