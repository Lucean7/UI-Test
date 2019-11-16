package testTrainigPageEpam;

import core.AbstractPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class FAQEpam extends AbstractPageObject {
    @FindBy(xpath = "//label[@class='accordion-item__question ng-binding'][contains(text(),'Are there any candidate specifications (age, education)?')]")
    private WebElement firstSentence;
    @FindBy(xpath = "//article[@class='accordion-item__answer ng-binding'][parent::div[@id='collapse--0']]")
    private WebElement firstSentenceText;
    @FindBy(xpath = "//a[@href='#!/Home']")
    private WebElement номеText;

    public FAQEpam(WebDriver driver) {
        super(driver);
    }
    public FAQEpam scrollTo(String s, WebElement webElement){
        js.executeScript(s,webElement);
        return this;
    }
    public FAQEpam isfirstSentenceContains(String s){
        fwait.until(ExpectedConditions.elementToBeClickable(firstSentence)).click();
        Assert.assertTrue(firstSentenceText.getText().contains(s),
                "This text does not exist.");
        return this;
    }
    public WebElement getHомеText(){
        return номеText;
    }
}
