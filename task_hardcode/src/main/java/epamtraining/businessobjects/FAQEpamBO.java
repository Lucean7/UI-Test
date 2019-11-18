package epamtraining.businessobjects;

import epamtraining.pageobject.FAQEpam;
import epamtraining.core.AbstractPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class FAQEpamBO extends AbstractPageObject{
    private FAQEpam faqEpam;

    public FAQEpamBO(WebDriver driver) {
        super(driver);
        this.faqEpam = initFAQEpam();
    }
    private FAQEpam initFAQEpam(){
        return new FAQEpam(driver);
    }
    public FAQEpam getFaqEpam() {
        return faqEpam;
    }

    public FAQEpamBO isSentenceContains(WebElement webElement, WebElement textElement, String text){
        fwait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
        Assert.assertTrue(fwait.until(ExpectedConditions.elementToBeClickable(textElement)).getText().contains(text),
                "This text does not exist.");
        return this;
    }
    public FAQEpamBO scrollTo(WebElement webElement){
        js.executeScript("arguments[0].scrollIntoView(true);",webElement);
        return this;
    }
}
