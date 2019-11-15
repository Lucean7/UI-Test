package testTrainigPageEpam;

import core.AbstractPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


import java.util.List;
import java.util.NoSuchElementException;

public class NewsEpam extends AbstractPageObject {
    @FindBy(xpath = "//span[contains(text(),'News')]")
    private WebElement newsTitle;
    @FindBy(xpath = "//span[contains(text(),'Success Stories')]")
    private WebElement successStoriesTitle;
    @FindBy(xpath = "//span[contains(text(),'Materials')]")
    private WebElement materialsTitle;
    @FindBy(xpath = "//span[contains(text(),'Videos')]")
    private WebElement videosTitle;


    public NewsEpam(WebDriver driver) {
        super(driver);
    }

    public NewsEpam isDisplayedNews() throws InterruptedException {
        try {
            newsTitle.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Video isn't displayed.");
        }
        return this;
    }

    public NewsEpam isDisplayedSuccessStories() {
        try {
            fwait.until(ExpectedConditions.elementToBeClickable(successStoriesTitle)).isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Video isn't displayed.");
        }
        return this;
    }

    public NewsEpam isDisplayedMaterials() {
        try {
            materialsTitle.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Video isn't displayed.");
        }
        return this;
    }

    public NewsEpam isDisplayedVideos() {
        try {
            fwait.until(ExpectedConditions.elementToBeClickable(videosTitle)).isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Video isn't displayed.");
        }
        return this;
    }

    public NewsEpam isAllLinksMaterialContains(String s1, String s2) {
        fwait.until(ExpectedConditions.elementToBeClickable(materialsTitle)).click();
        List<WebElement> linkTitle = driver.findElements(By.xpath("//a[@class='ng-binding'][parent::div]"));
        for (WebElement link : linkTitle) {
            Assert.assertTrue((link.getText().toLowerCase().contains(s1) || link.getText().toLowerCase().contains(s2)),
                    "Material link=" + link + " is not contains ‘materials’ or ‘useful’");

        }
        return this;
    }
}