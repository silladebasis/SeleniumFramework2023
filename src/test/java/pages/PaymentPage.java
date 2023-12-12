package pages;

import org.openqa.selenium.By;
import static driver.DriverManager.getDriver;
import static utils.CommonFunctions.clickElement;
public class PaymentPage {
    private final By card_name = By.cssSelector("[data-qa='name-on-card']");
    private final By card_number = By.cssSelector("[data-qa='card-number']");
    private final By cvc = By.cssSelector("[data-qa='cvc']");
    private final By expiry_month = By.cssSelector("[data-qa='expiry-month']");
    private final By expiry_year = By.cssSelector("[data-qa='expiry-year']");
    private final By pay_confirm_button = By.xpath("//button[normalize-space()='Pay and Confirm Order']");
    public PaymentPage enterPaymentInfo(String name, String number){
        getDriver().findElement(card_name).sendKeys(name);
        getDriver().findElement(card_number).sendKeys(number);
        getDriver().findElement(cvc).sendKeys("123");
        getDriver().findElement(expiry_month).sendKeys("01");
        getDriver().findElement(expiry_year).sendKeys("2000");
        return this;
    }
    public PaymentPage clickOnConfirmOrder(){
        clickElement(pay_confirm_button);
        //getDriver().findElement(pay_confirm_button).click();
        return this;
    }
}
