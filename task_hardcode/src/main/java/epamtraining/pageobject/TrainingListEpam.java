package epamtraining.pageobject;

import epamtraining.core.AbstractPageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class TrainingListEpam extends AbstractPageObject {
    @FindBy(xpath = "//a[@href='/#!/TrainingList'][ancestor::ul[@class='main-nav__list']]")
    private WebElement titlTrainingList;
    @FindBy(xpath = "//div[@class='filter-toggle__arrow-icon']")
    private  WebElement arroIconDown;
    @FindBy(xpath = "//div[@class='navigation-item ng-binding']")
    private  WebElement bySkills;
    @FindBy(xpath = "//ul[@class='location__cities-list-cities location__cities-list-skills']/li[14]/label")
    private  WebElement skillsJava;
    @FindBy(xpath = "//div[@class='filter-toggle__arrow-icon arrow-icon-rotate']")
    private  WebElement arrowIconRotate;
    @FindBy(xpath = "//span[@ng-click='clearAllLocations(totalLocationList)']")
    private  WebElement deleteLocation;
    @FindBy(xpath = "//div[@class='training-item__inner'][ancestor::div[@class='training-list__container training-list__desktop']]")
    private  WebElement skillsJavaExist;
    @FindBy(xpath = "//span[@ng-click='clearAllSkills(selectedSkills)']")
    private  WebElement skillsDelet;
    @FindBy(xpath = "//input[@ng-model='searchFilter']")
    private  WebElement searchBox;
    @FindBy(xpath = "//ul[@class='location__cities-list-cities location__cities-list-skills']/li[9]/label/span")
    private  WebElement dataScience;
    @FindBy(xpath = "//ul[@class='location__cities-list-cities location__cities-list-skills']/li[8]/label/span")
    private  WebElement dataEngineering;
    @FindBy(xpath = "//div[@class='training-item__button']")
    private  WebElement skillsDataExist;
    @FindBy(xpath = "//div[@class='location__cities location__skills']")
    private  WebElement tableOfSkills;
    @FindBy(xpath = "//div[contains(text(),'locations')][parent::div[@class='drop-down-choose__header']]")
    private  WebElement selectLocation;
    @FindBy(xpath = "//div[contains(text(),'Ukraine')][parent::li[@ng-repeat='locations in locationNames']]")
    private  WebElement selectUkraine;
    @FindBy(xpath = "//ul[@class='location__cities-list-cities ng-scope']/li[4]/label/span")
    private  WebElement selectLiviv;
    @FindBy(xpath = "//div[@class='yellow-info-banner__item--description ng-binding']")
    private  WebElement yellowInfoBanner;
    @FindBy(xpath = "//div[@class='training-item__title']")
    private List<WebElement> tableLinkT;


    public TrainingListEpam(WebDriver driver) {
        super(driver);
    }


    public WebElement getTitlTrainingList() {
        return titlTrainingList;
    }

    public WebElement getArroIconDown() {
        return arroIconDown;
    }

    public WebElement getBySkills() {
        return bySkills;
    }

    public WebElement getSkillsJava() {
        return skillsJava;
    }

    public WebElement getArrowIconRotate() {
        return arrowIconRotate;
    }

    public WebElement getDeleteLocation() {
        return deleteLocation;
    }

    public WebElement getSkillsJavaExist() {
        return fwait.until(ExpectedConditions.elementToBeClickable(skillsJavaExist));
    }

    public WebElement getSkillsdelet() {
        return skillsDelet;
    }

    public WebElement getSearchBox() {
        return searchBox;
    }

    public WebElement getDataScience() {
        return dataScience;
    }

    public WebElement getDataEngineering() {
        return dataEngineering;
    }

    public WebElement getSkillsDataExist() {
        return skillsDataExist;
    }

    public WebElement getTableOfSkills() {
        return tableOfSkills;
    }

    public WebElement getSelectLocation() {
        return selectLocation;
    }

    public WebElement getSelectUkraine() {
        return selectUkraine;
    }

    public WebElement getSelectLiviv() {
        return selectLiviv;
    }

    public WebElement getYellowInfoBanner() {
        return yellowInfoBanner;
    }

    public List<WebElement> getTableLinkT() {
        return tableLinkT;
    }
}
