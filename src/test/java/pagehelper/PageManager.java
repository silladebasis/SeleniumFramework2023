package pagehelper;

import pages.*;

public class PageManager {
    protected LoginPage loginPage;
    protected HeaderComponentPage headerComponentPage;
    protected ProductsPage productsPage;
    protected ProductDetailsPage productDetailsPage;
    protected ReviewPage reviewPage;
    protected CartPage cartPage;
    protected PaymentPage paymentPage;
    protected ConfirmationPage confirmationPage;
    public LoginPage getLoginPage(){
        loginPage = new LoginPage();
        return loginPage;
    }
    public HeaderComponentPage getHeaderComponentsPage(){
        headerComponentPage = new HeaderComponentPage();
        return headerComponentPage;
    }
    public ProductsPage getProductsPage(){
        productsPage = new ProductsPage();
        return productsPage;
    }
    public ProductDetailsPage getProductDetailsPage(){
        productDetailsPage = new ProductDetailsPage();
        return productDetailsPage;
    }
    public ReviewPage getReviewPage(){
        reviewPage = new ReviewPage();
        return reviewPage;
    }
    public CartPage getCartPage(){
        cartPage = new CartPage();
        return cartPage;
    }
    public PaymentPage getPaymentPage(){
        paymentPage = new PaymentPage();
        return paymentPage;
    }
    public ConfirmationPage getConfirmationPage(){
        confirmationPage = new ConfirmationPage();
        return confirmationPage;
    }
}
