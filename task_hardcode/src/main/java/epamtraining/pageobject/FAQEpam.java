package epamtraining.pageobject;

import epamtraining.core.AbstractPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FAQEpam extends AbstractPageObject {
    @FindBy(xpath = "//label[@class='accordion-item__question ng-binding'][contains(text(),'How much does it cost to study at EPAM Training Center?')]")
    private WebElement firstSentence;
    @FindBy(xpath = "//article[@class='accordion-item__answer ng-binding'][parent::div[@id='collapse--2']]")
    private WebElement firstSentenceText;
    @FindBy(xpath = "//a[@href='#!/Home']")
    private WebElement homeText;

    public FAQEpam(WebDriver driver) {
        super(driver);
    }
    public WebElement getHomeText(){
        return homeText;
    }
    public WebElement getFirstSentence() {
        return firstSentence;
    }
    public WebElement getFirstSentenceText() {
        return firstSentenceText;
    }
}
