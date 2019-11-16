package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class InitialWebDriver {
    private static WebDriver instance;
    private static WebDriver getWebDriver() {
        WebDriver driver;
        String webDriver = System.getProperty("browser");
        if (isSame(webDriver,"firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (isSame(webDriver,"chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            throw new WebDriverException("This is an incorrect webDriver input - " + webDriver);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
    private static boolean isSame(String val1, String val2) {
        return val1 != null && val2 != null && val1.equalsIgnoreCase(val2);
    }

    public static void closeDriver() {
        if (instance != null) {
            instance.quit();
            instance = null;
        }
    }
    public  static WebDriver getInstans(){
        if(instance == null){
            synchronized (InitialWebDriver.class){
                if(instance == null){
                    instance = getWebDriver();
                }
            }
        }
        return instance;
    }
}
