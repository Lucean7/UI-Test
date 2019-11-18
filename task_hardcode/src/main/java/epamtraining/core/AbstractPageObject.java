package epamtraining.core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;


public abstract class AbstractPageObject {
    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected Wait<WebDriver> fwait;
    protected WebDriverWait wait;
    public AbstractPageObject(WebDriver driver) {
        this.driver = driver;
        this.js = initSJavascriptExecutor();
        this.fwait = initFluentWait();
        this.wait= initWebDriverWait();
        PageFactory.initElements(driver, this);
    }
    private JavascriptExecutor initSJavascriptExecutor(){
        return (JavascriptExecutor)driver;
    }

    protected Wait<WebDriver> initFluentWait() {
        return new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }
    protected WebDriverWait initWebDriverWait() {
        return new WebDriverWait(driver, 10);
    }

}
