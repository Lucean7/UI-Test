package epamtraining.pageobject;

import epamtraining.core.AbstractPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutEpam extends AbstractPageObject {
    @FindBy(xpath = "//article[@class='accordion-item__answer ng-binding'][parent::div[@id='collapse--0']]")
    private WebElement firstSentenceText;
    @FindBy(xpath = "//li[@ng-repeat='country in countries'][contains(text(),'Ukraine')]")
    private WebElement mapUkraine;
    @FindBy(xpath = "//p[@class='city-item__city-title ng-binding'][contains(text(),'Lviv')]")
    private WebElement mapLviv;
    @FindBy(xpath = "//p[@class='city-item__street-name ng-binding'][contains(text(),'Shevchenka str. 111a')]")
    private WebElement addressOfLviv;
    @FindBy(xpath = "//section[@class='join-epam__student-steps steps-list steps-list--student']/section[2]/p")
    private WebElement titleWhereWeAre;

    public AboutEpam(WebDriver driver) {
        super(driver);
    }
    public WebElement getMapUkraine() {
        return mapUkraine;
    }
    public WebElement getMapLviv() {
        return mapLviv;
    }
    public WebElement getAddressOfLviv() {
        return addressOfLviv;
    }
    public WebElement geTtitleWhereWeAre() {
        return titleWhereWeAre;
    }
}
