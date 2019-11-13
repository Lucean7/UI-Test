package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverInitialization {
    public static WebDriver getWebDriver() {
        String webDriver = System.getProperty("browser");
        if (isSame(webDriver,"firefox")) {
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return driver;
        } else if (isSame(webDriver,"chrome")) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return driver;

        } else {
            throw new WebDriverException("This is an incorrect webDriver input - " + webDriver);
        }
    }
    private static boolean isSame(String val1, String val2) {
        return val1 != null && val2 != null && val1.equalsIgnoreCase(val2);
    }

}
