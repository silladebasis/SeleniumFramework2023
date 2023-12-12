package data;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "testData")
    public Object[][] getLoginData(){
        return new Object[][]{{"test_automation@gmail.com","Automation@123"}};
    }
}
