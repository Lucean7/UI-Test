package epamtraining.pageobject;

import epamtraining.core.AbstractPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsEpam extends AbstractPageObject {
    @FindBy(xpath = "//span[contains(text(),'News')]")
    private WebElement newsTitle;
    @FindBy(xpath = "//span[contains(text(),'Success Stories')]")
    private WebElement successStoriesTitle;
    @FindBy(xpath = "//span[contains(text(),'Materials')]")
    private WebElement materialsTitle;
    @FindBy(xpath = "//span[contains(text(),'Videos')]")
    private WebElement videosTitle;
    @FindBy(xpath = "//a[@class='ng-binding'][parent::div]" )
    private List<WebElement> linkTitleMaterial;

    public NewsEpam(WebDriver driver) {
        super(driver);
    }

    public WebElement getNewsTitle() {
        return newsTitle;
    }

    public WebElement getSuccessStoriesTitle() {
        return successStoriesTitle;
    }

    public WebElement getMaterialsTitle() {
        return materialsTitle;
    }

    public WebElement getVideosTitle() {
        return videosTitle;
    }

    public List<WebElement> getLinkTitleMaterial() {
        return linkTitleMaterial;
    }
}