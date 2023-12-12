package tests;

import base.BaseTest;
import data.TestData;
import dataModel.UserData;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static driver.DriverManager.getDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class E2ETest extends BaseTest {
    public E2ETest(){
        loginPage = pageManager.getLoginPage();
        headerComponentPage = pageManager.getHeaderComponentsPage();
        productsPage = pageManager.getProductsPage();
        productDetailsPage = pageManager.getProductDetailsPage();
        cartPage = pageManager.getCartPage();
        reviewPage = pageManager.getReviewPage();
        paymentPage = pageManager.getPaymentPage();
        confirmationPage = pageManager.getConfirmationPage();
    }
    @Test(dataProvider = "testData",dataProviderClass = TestData.class,groups = "Regression")
    public void validate_product_checkout_e2e(String email,String password) throws InterruptedException {
        loginPage.loginToApp(email,password);
        headerComponentPage.navigateToProductPage();
        UserData userdata = jsonReader.getUsers("1");
        if(productsPage.isSearchProductDisplayed()){
            System.out.println(userdata.getProductName());
            productsPage.searchProduct(userdata.getProductName());
        }
        assertEquals(productsPage.getProductCount(),1);
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("window.scrollBy(0,400)");
        productsPage.clickOnViewCart();
        productDetailsPage.clickOnAddToCart();
        Thread.sleep(2000);
        String productAddedText = productDetailsPage.verifyProductAddedToCartMsg();
        System.out.println(productAddedText);
        assertEquals(productAddedText,"Your product has been added to cart.");
        cartPage.clickOnViewCart()
                .clickOnPlaceOrderBtn();
        assertTrue(getDriver().getCurrentUrl().contains("checkout"),"Unable to navigate to checkout page");
        String reviewOrderText = reviewPage.getReviewText();
        System.out.println(reviewOrderText);
        assertEquals(reviewOrderText,"Review Your Order");
        reviewPage.clickOnPlaceOrder();
        assertTrue(getDriver().getCurrentUrl().contains("payment"),"Unable to navigate to payment page");
        paymentPage.enterPaymentInfo(userdata.getCardName(), userdata.getCardNumber())
                .clickOnConfirmOrder();
        assertTrue(getDriver().getCurrentUrl().contains("payment_done"),"Unable to navigate to payment page");
        String confirmText = confirmationPage.getConfirmationText();
        System.out.println(confirmText);
        assertEquals(confirmText,"Congratulations! Your order has been confirmed!");
    }
}
