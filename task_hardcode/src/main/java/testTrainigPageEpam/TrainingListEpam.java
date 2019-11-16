package testTrainigPageEpam;

import core.AbstractPageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.NoSuchElementException;

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
    @FindBy(xpath = "//a[@class='training-item__title-link ng-binding'][parent::div[@class='training-item__title']]")
    private  WebElement skillsJavaExist;
    @FindBy(xpath = "//span[@ng-click='clearAllSkills(selectedSkills)']")
    private  WebElement skillsJavaDelet;
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
    private  WebElement selectTrainings;
    @FindBy(xpath = "//div[@class='training-item__title']")
    private List<WebElement> tableLinkT;


    public TrainingListEpam(WebDriver driver) {
        super(driver);
    }
    public TrainingListEpam scrollTo(String s){
        js.executeScript(s);
        return this;
    }
    public TrainingListEpam arrowIconDownClick(){
        fwait.until(ExpectedConditions.elementToBeClickable(arroIconDown)).click();
        return this;
    }
    public TrainingListEpam bySkillsClick(){
        fwait.until(ExpectedConditions.elementToBeClickable(bySkills)).click();
        return this;
    }
    public TrainingListEpam skillsJavaClick(){
        fwait.until(ExpectedConditions.elementToBeClickable(skillsJava)).click();
        return this;
    }
    public TrainingListEpam arrowIconRotateClick(){
        fwait.until(ExpectedConditions.elementToBeClickable(arrowIconRotate)).click();
        return this;
    }
    public TrainingListEpam deleteLocationClick(){
        fwait.until(ExpectedConditions.elementToBeClickable(deleteLocation)).click();
        return this;
    }
    public TrainingListEpam skillsJavaExist(){
        try {
            skillsJavaExist.isDisplayed();
        }catch (NoSuchElementException e){
            System.out.println("Skills Java doesn't exist.");
        }
        return this;
    }
    public TrainingListEpam skillsDataExist(){
        try {
            skillsDataExist.isDisplayed();
        }catch (NoSuchElementException e){
            System.out.println("Skills Data doesn't exist.");
        }
        return this;
    }
    public TrainingListEpam skillsJavaDeletClick(){
        fwait.until(ExpectedConditions.elementToBeClickable(skillsJavaDelet)).click();
        return this;
    }
    public TrainingListEpam dataClick(){
        fwait.until(ExpectedConditions.elementToBeClickable(dataScience))
        .click();
        fwait.until(ExpectedConditions.elementToBeClickable(dataEngineering))
        .click();
        return this;
    }
    public TrainingListEpam inputSearchBoxClick(String s){
        fwait.until(ExpectedConditions.elementToBeClickable(searchBox))
        .sendKeys(s);
        return this;
    }
    public TrainingListEpam searchBoxClick(){
        searchBox.click();
        return this;
    }
    public TrainingListEpam skillsPascalExist(){
        Assert.assertFalse(tableOfSkills.getText().contains("Pascal"),"Incorrect work.Skills Pascal exist.");
        return this;
    }
    public TrainingListEpam selectUkraine() {
        fwait.until(ExpectedConditions.elementToBeClickable(selectUkraine))
        .click();
        return this;
    }
    public TrainingListEpam selectLviv() {
        fwait.until(ExpectedConditions.elementToBeClickable(selectLiviv))
        .click();
        return this;
    }
    public TrainingListEpam selectLocation() {
        fwait.until(ExpectedConditions.elementToBeClickable(selectLocation))
        .click();
        return  this;
    }
    public TrainingListEpam isSearchResultsReturned() {
        List<WebElement> tableLink = tableLinkT ;
        Assert.assertTrue(tableLink.size()!=0,"No results found for this search.");
        return this;
    }
    public WebElement selectTrainings(){
        return fwait.until(ExpectedConditions.elementToBeClickable(selectTrainings));
    }
}
