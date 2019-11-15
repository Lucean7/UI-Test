package core;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;


public abstract class AbstractPageObject {
    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected Wait<WebDriver> fwait;
    public AbstractPageObject(WebDriver driver) {
        this.driver = driver;
        this.js = initSJavascriptExecutor();
        this.fwait = fwait();
        PageFactory.initElements(driver, this);
    }

    private JavascriptExecutor initSJavascriptExecutor(){
        return (JavascriptExecutor)driver;
    }

    protected Wait<WebDriver> fwait() {
        return new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }

}
