package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(WebDriver driverl){
        if(driver.get()==null){
            driver.set(driverl);
        }
    }

    public static WebDriver getDriver(){
        return driver.get();
    }
}
