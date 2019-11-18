package epamtraining.businessobjects;

import epamtraining.core.AbstractPageObject;
import epamtraining.pageobject.AboutEpam;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AboutEpamBO extends AbstractPageObject{
    private AboutEpam aboutEpam;

    public AboutEpamBO(WebDriver driver) {
        super(driver);
        this.aboutEpam = initAboutEpam();
    }
    private AboutEpam initAboutEpam(){
      return new AboutEpam(driver);
    }
    public AboutEpam getAboutEpam() {
        return aboutEpam;
    }
    public AboutEpamBO scrollTo(WebElement webElement){
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
        return this;
    }
    public AboutEpamBO checkAddress(WebElement country,WebElement city,WebElement street, String s) {
        fwait.until(ExpectedConditions.elementToBeClickable(country)).click();
        fwait.until(ExpectedConditions.elementToBeClickable(city)).click();
        Assert.assertTrue(fwait.until(ExpectedConditions.elementToBeClickable(street)).getText().contains(s),"Wrong address.");
        return this;
    }
}
