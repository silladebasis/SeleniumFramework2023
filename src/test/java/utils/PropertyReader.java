package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    protected static Properties properties;
    protected static FileInputStream fileInputStream;
    private static Properties getProperty(){
        properties = new Properties();
        try{
            fileInputStream = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    public static String getBaseURL(){
        return getProperty().getProperty("url");
    }
    public static String getBrowserName(){
        return getProperty().getProperty("browser");
    }
}

