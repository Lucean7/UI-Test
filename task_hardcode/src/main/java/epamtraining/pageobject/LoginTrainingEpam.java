package epamtraining.pageobject;


import epamtraining.core.AbstractPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


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


    public WebElement getUserInfoName() {
        return userInfoName;
    }

    public WebElement getUserLogout() {
        return userLogout;
    }

    public WebElement getUserMenu() {
        return userMenu;
    }

    public WebElement getTitleNews() {
        return fwait.until(ExpectedConditions.elementToBeClickable(titleNews));
    }

    public WebElement getTitlTrainingList() {
        return fwait.until(ExpectedConditions.elementToBeClickable(titlTrainingList));
    }

    public WebElement getTitlFAQ() {
        return fwait.until(ExpectedConditions.elementToBeClickable(titlFAQ));
    }

    public WebElement getTitleAbout() {
        return fwait.until(ExpectedConditions.elementToBeClickable(titleAbout));
    }
}
