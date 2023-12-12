package pages;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import utils.CommonFunctions;

public class LoginPage extends CommonFunctions {
    private final By txtEmail = By.cssSelector("[data-qa='login-email']");
    private final By txtPassword = By.cssSelector("[data-qa='login-password']");
    private final By btnLogin = By.cssSelector("[data-qa='login-button']");

    public LoginPage loginToApp(String email,String password){
        try{
            enterText(txtEmail,email);
            enterText(txtPassword,password);
            clickElement(btnLogin);
//            getDriver().findElement(txtEmail).sendKeys(email);
//            getDriver().findElement(txtPassword).sendKeys(password);
//            getDriver().findElement(btnLogin).click();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage() + "Element not found");
        }
        return this;
    }
}
