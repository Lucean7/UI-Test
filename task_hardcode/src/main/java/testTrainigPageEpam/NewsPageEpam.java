package testTrainigPageEpam;

import core.PageFactoryInitialization;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


import java.time.Duration;
import java.util.List;

public class NewsPageEpam extends PageFactoryInitialization {
    private Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(2));
    @FindBy(xpath = "//span[contains(text(),'News')]")
    private WebElement newsTitle;
    @FindBy(xpath = "//span[contains(text(),'Success Stories')]")
    private WebElement successStoriesTitle;
    @FindBy(xpath = "//span[contains(text(),'Materials')]")
    private WebElement MaterialsTitle;
    @FindBy(xpath = "//span[contains(text(),'Videos')]")
    private WebElement videosTitle;
    @FindBy(xpath = "//a[@class='ng-binding'][parent::div]")
    private WebElement tableNews;

    public NewsPageEpam(WebDriver driver) {
        super(driver);
    }
    public boolean displayedNews() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'News')]")));
        return newsTitle.isDisplayed();
    }
    public boolean displayedSuccessStories() {
        return successStoriesTitle.isDisplayed();
    }
    public boolean displayedMaterials() {
        return MaterialsTitle.isDisplayed();
    }
    public boolean displayedVideos() {
        return videosTitle.isDisplayed();
    }
    public boolean checkExistWord() {
        newsTitle.click();
        List<WebElement> allNews = driver.findElements(By.xpath("//a[@class='ng-binding'][parent::div]"));
        List<WebElement> allNewsContainsWord = driver.findElements(By.xpath("//a[contains(text(),'materials') or contains(text(),'useful')]"));
        return allNews.size() == allNewsContainsWord.size();
    }
}
