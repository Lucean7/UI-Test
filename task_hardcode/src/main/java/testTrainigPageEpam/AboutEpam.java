package testTrainigPageEpam;

import core.AbstractPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AboutEpam extends AbstractPageObject {
    @FindBy(xpath = "//article[@class='accordion-item__answer ng-binding'][parent::div[@id='collapse--0']]")
    private WebElement firstSentenceText;
    @FindBy(xpath = "//li[@ng-repeat='country in countries'][contains(text(),'Ukraine')]")
    private WebElement mapUkraine;
    @FindBy(xpath = "//p[@class='city-item__city-title ng-binding'][contains(text(),'Lviv')]")
    private WebElement mapLviv;
    @FindBy(xpath = "//p[@class='city-item__street-name ng-binding'][contains(text(),'Shevchenka str. 111a')]")
    private WebElement addressOfLviv;

    public AboutEpam(WebDriver driver) {
        super(driver);
    }

    public AboutEpam scrollTo(String s){
        js.executeScript(s);
        return this;
    }
    public AboutEpam mapUkraineClick() {
        fwait.until(ExpectedConditions.elementToBeClickable(mapUkraine)).click();
        return this;
    }
    public AboutEpam isAddressOfLviv(String s) {
        fwait.until(ExpectedConditions.elementToBeClickable(mapLviv)).click();
        Assert.assertTrue(fwait.until(ExpectedConditions.elementToBeClickable(addressOfLviv)).getText().contains(s),"Wrong address.");
        return this;
    }
}
