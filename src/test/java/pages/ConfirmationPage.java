package pages;

import org.openqa.selenium.By;
import static driver.DriverManager.getDriver;
import static utils.CommonFunctions.waitForElement;
public class ConfirmationPage {
    private final By confirm_text = By.xpath("(//div/p)[1]");
    public String getConfirmationText(){
        waitForElement(confirm_text);
        return getDriver().findElement(confirm_text).getText();
    }
}
