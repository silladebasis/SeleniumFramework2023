package tests;

import base.BaseTest;
import data.TestData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static driver.DriverManager.getDriver;
public class loginTest extends BaseTest {
    @Test(dataProvider = "testData",dataProviderClass = TestData.class,groups = "Smoke")
    public void loginTest(String email,String password) {
        getDriver().findElement(By.cssSelector("[data-qa='login-email']")).sendKeys(email);
        getDriver().findElement(By.cssSelector("[data-qa='login-password']")).sendKeys(password);
        getDriver().findElement(By.cssSelector("[data-qa='login-button']")).click();
        getDriver().findElement(By.cssSelector("a[href='/products']")).click();
    }
}
