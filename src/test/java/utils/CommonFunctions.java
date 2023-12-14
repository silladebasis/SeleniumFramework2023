package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import static driver.DriverManager.getDriver;

// These are common functions which can be used across tests
public class CommonFunctions {
    public  static void waitForElement(By locator){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static void implicitWait(){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public static void clickElement(By locator){
        waitForElement(locator);
        getDriver().findElement(locator).click();
    }
    public static WebElement getElement(By locator){
        return getDriver().findElement(locator);
    }
    public static void enterText(By locator,String text){
        waitForElement(locator);
        getDriver().findElement(locator).sendKeys(text);
    }

    public static void captureScreenshot(String testName){
        TakesScreenshot ts = (TakesScreenshot) getDriver();
        File src = ts.getScreenshotAs(OutputType.FILE);
        try{
            FileHandler.copy(src,new File(System.getProperty("user.dir")+ "/src/test/java/screenshots" + testName + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
