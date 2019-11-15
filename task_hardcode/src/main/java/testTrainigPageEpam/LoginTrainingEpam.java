package testTrainigPageEpam;

import core.AbstractPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginTrainingEpam extends AbstractPageObject {
    @FindBy(xpath = "//div[@class='user-info__name'][parent::a]")
    private  WebElement userInfoName;
    @FindBy(xpath = "//a[@href='/Auth/Logout'][ancestor::div[not(contains(@id,'user-info dropdown-toggle'))]]")
    private  WebElement userLogout;
    @FindBy(xpath = "//div[@class='arrow'][parent::div[@class='user-info__arrow'][preceding-sibling::div]]")
    private WebElement userMenu;
    @FindBy(xpath = "//a[@href='/#!/News'][ancestor::ul[@class='main-nav__list']]")
    private  WebElement titleNews;
    @FindBy(xpath = "//a[@href='/#!/TrainingList'][ancestor::ul[@class='main-nav__list']]")
    private  WebElement titlTrainingList;
    @FindBy(xpath = "//a[contains(text(),'FAQ')][ancestor::ul[@class='main-nav__list']]")
    private  WebElement titlFAQ;
    @FindBy(xpath = "//a[contains(text(),'About')][ancestor::ul[@class='main-nav__list']]")
    private  WebElement titleAbout;

    public LoginTrainingEpam(WebDriver driver) {
        super(driver);
    }
    public LoginTrainingEpam getUserInfoName(String name) {
        Assert.assertEquals(name,userInfoName.getText(), "Incorrect work.");
        return this;
    }
    public LoginTrainingEpam logoutTraining() {
        userMenu.click();
        userLogout.click();
        return this;
    }
    public TrainingListEpam passToTrainingListEpam() {
        fwait.until(ExpectedConditions.elementToBeClickable(titlTrainingList)).click();
        return new TrainingListEpam(driver);
    }
    public FAQEpam passToFAQEpam() {
        fwait.until(ExpectedConditions.elementToBeClickable(titlFAQ)).click();
        return new FAQEpam(driver);
    }
    public NewsEpam passToNewsEpam(){
        fwait.until(ExpectedConditions.elementToBeClickable(titleNews)).click();
        return new NewsEpam(driver);
    }
    public AboutEpam passToAboutEpam(){
        fwait.until(ExpectedConditions.elementToBeClickable(titleAbout)).click();
        return new AboutEpam(driver);
    }
}
