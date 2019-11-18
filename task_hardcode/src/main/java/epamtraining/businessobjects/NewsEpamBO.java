package epamtraining.businessobjects;

import epamtraining.core.AbstractPageObject;
import epamtraining.pageobject.NewsEpam;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.NoSuchElementException;

public class NewsEpamBO extends AbstractPageObject{
    private NewsEpam newsEpam;

    public NewsEpamBO(WebDriver driver) {
        super(driver);
        this.newsEpam = initAboutEpam();
    }
    private NewsEpam initAboutEpam(){
        return new NewsEpam(driver);
    }

    public NewsEpam getNewsEpam() {
        return newsEpam;
    }

    public NewsEpamBO isDisplayed(WebElement webElement, String s) {
        try {
            fwait.until(ExpectedConditions.elementToBeClickable(webElement)).isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println( s +" isn't displayed.");
        }
        return this;
    }

    public NewsEpamBO isLinksContains(WebElement titel,List<WebElement> linlsTitle,String s1, String s2) {
        fwait.until(ExpectedConditions.elementToBeClickable(titel)).click();
        List<WebElement> linkTitle = fwait.until(ExpectedConditions.visibilityOfAllElements(linlsTitle));
        for (WebElement link : linkTitle) {
            Assert.assertTrue((link.getText().toLowerCase().contains(s1) || link.getText().toLowerCase().contains(s2)),
                    "Material link=" + link + " is not contains "+s1+" or "+s2+".");
        }
        return this;
    }

}
