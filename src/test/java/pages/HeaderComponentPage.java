package pages;

import org.openqa.selenium.By;
import static utils.CommonFunctions.clickElement;
public class HeaderComponentPage {
    private final By productLink = By.cssSelector("a[href='/products']");
    public void navigateToProductPage(){
        clickElement(productLink);
//        waitForElement(productLink);
//        getDriver().findElement(productLink).click();
    }
}
