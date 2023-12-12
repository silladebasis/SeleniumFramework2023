package base;
import driver.DriverManager;
import pagehelper.PageManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.JsonReader;

import static driver.DriverManager.getDriver;
import static driver.DriverManager.setDriver;
import static utils.PropertyReader.getBaseURL;

public class BaseTest extends PageManager {
    protected PageManager pageManager;
    protected JsonReader jsonReader = new JsonReader();
    public BaseTest(){
        pageManager = new PageManager();
    }
    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        //options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        setDriver(new ChromeDriver(options));
        getDriver().get(getBaseURL());
    }
    @AfterMethod()
    public void tearDown(){
        getDriver().quit();
        setDriver(null);
    }
}
