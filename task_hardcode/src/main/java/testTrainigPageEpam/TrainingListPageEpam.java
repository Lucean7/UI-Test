package testTrainigPageEpam;

import core.PageFactoryInitialization;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


import java.time.Duration;
import java.util.List;

public class TrainingListPageEpam extends PageFactoryInitialization{
    private Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(2));
    JavascriptExecutor js = (JavascriptExecutor)driver;
    @FindBy(xpath = "//a[@href='/#!/TrainingList'][ancestor::ul[@class='main-nav__list']]")
    private WebElement titlTrainingList;
    @FindBy(xpath = "//div[@class='filter-toggle__arrow-icon']")
    private  WebElement arroIconDown;
    @FindBy(xpath = "//div[@class='navigation-item ng-binding active']")
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

    public TrainingListPageEpam(WebDriver driver) {
        super(driver);
    }
    public void scrollToTrainings(String s){
        js.executeScript(s);
    }
    public void arroIconDownClick() throws InterruptedException {
        arroIconDown.click();
    }
    public void bySkillsClick(){
        bySkills.click();
    }
    public void skillsJavaClick(){
        skillsJava.click();
    }
    public void arrowIconRotateClick(){
        arrowIconRotate.click();
    }
    public void deleteLocationClick(){
        wait.until(ExpectedConditions.visibilityOf(deleteLocation));
        deleteLocation.click();
    }
    public boolean skillsJavaExist(){
        return skillsJavaExist.isDisplayed();
    }
    public boolean skillsDataExist(){
        return skillsDataExist.isDisplayed();
    }
    public void skillsJavaDeletClick(){
        skillsJavaDelet.click();
    }
    public void dataScienceClick(){
        dataScience.click();
    }
    public void dataEngineeringClick(){
        dataEngineering.click();
    }
    public void inputSearchBoxClick(String s){
        searchBox.sendKeys(s);
    }
    public void searchBoxClick(){
        searchBox.click();
    }
    public boolean getTableOfSkills(){
        return tableOfSkills.getText().isEmpty();
    }
    public void selectUkraine() {
        selectUkraine.click();
    }
    public void selectLviv() {
        selectLiviv.click();
    }
    public void selectLocation() {
        selectLocation.click();
    }
    public boolean checkSearchResulted() {
        List<WebElement> tableLink = driver.findElements(By.xpath("//div[@class='training-item__title']"));
        return tableLink.size()!=0;
    }
}
