package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageFactoryInitialization {
    protected WebDriver driver;

    public PageFactoryInitialization(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
