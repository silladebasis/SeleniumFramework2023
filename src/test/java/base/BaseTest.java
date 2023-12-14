package base;
import driver.DriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
import static utils.PropertyReader.getBrowserName;

public class BaseTest extends PageManager {
    protected PageManager pageManager;
    protected JsonReader jsonReader = new JsonReader();
    protected String browser;
    public BaseTest(){
        pageManager = new PageManager();
    }
    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        browser = System.getProperty("browser")!=null ? System.getProperty("browser") : getBrowserName();

        switch(browser){
            case "Chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");
                //options.addArguments("--incognito");
                options.addArguments("--start-maximized");
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                setDriver(new ChromeDriver(options));
                break;
            case "Firefox":
                setDriver(new FirefoxDriver());
                break;
            default:
                throw new Exception("No specific browser found ");
        }
        getDriver().get(getBaseURL());
        getDriver().manage().window().maximize();
    }
    @AfterMethod()
    public void tearDown(){
        getDriver().quit();
        setDriver(null);
    }
}
