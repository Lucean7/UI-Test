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

    public AboutEpamBO scrollToMap(){
        js.executeScript("arguments[0].scrollIntoView(true);", aboutEpam.geTtitleWhereWeAre());
        return this;
    }

    public AboutEpamBO checkAddressLvivEpam(String s) {
        fwait.until(ExpectedConditions.elementToBeClickable(aboutEpam.getMapUkraine())).click();
        fwait.until(ExpectedConditions.elementToBeClickable(aboutEpam.getMapLviv())).click();
        Assert.assertTrue(fwait.until(ExpectedConditions.elementToBeClickable(aboutEpam.getAddressOfLviv()))
                .getText().contains(s),"Wrong address.");
        return this;
    }
}
