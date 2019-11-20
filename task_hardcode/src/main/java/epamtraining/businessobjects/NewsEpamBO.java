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

    public NewsEpamBO isSuccessStoriesTitleDisplayed() {
        try {
            fwait.until(ExpectedConditions.elementToBeClickable(newsEpam.getSuccessStoriesTitle())).isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println( "Success Stories Title isn't displayed.");
        }
        return this;
    }

    public NewsEpamBO isMaterialsTitleDisplayed() {
        try {
            fwait.until(ExpectedConditions.elementToBeClickable(newsEpam.getMaterialsTitle())).isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Materials Title isn't displayed.");
        }
        return this;
    }

    public NewsEpamBO isNewsTitleDisplayed() {
        try {
            fwait.until(ExpectedConditions.elementToBeClickable(newsEpam.getNewsTitle())).isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("News Title isn't displayed.");
        }
        return this;
    }

    public NewsEpamBO isVideosTitleDisplayed() {
        try {
            fwait.until(ExpectedConditions.elementToBeClickable(newsEpam.getVideosTitle())).isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Videos Title isn't displayed.");
        }
        return this;
    }

    public NewsEpamBO isLinksMaterialsTitleContains(String s1, String s2){
        fwait.until(ExpectedConditions.elementToBeClickable(newsEpam.getMaterialsTitle())).click();
        List<WebElement> linkTitle = fwait.until(ExpectedConditions.visibilityOfAllElements(newsEpam.getLinkTitleMaterial()));
        for (WebElement link : linkTitle) {
            Assert.assertTrue((link.getText().toLowerCase().contains(s1) || link.getText().toLowerCase().contains(s2)),
                    "Material link=" + link + " is not contains "+s1+" or "+s2+".");
        }
        return this;
    }

}
