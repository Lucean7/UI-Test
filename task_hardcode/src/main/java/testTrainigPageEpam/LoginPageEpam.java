package testTrainigPageEpam;

import core.PageFactoryInitialization;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class LoginPageEpam extends PageFactoryInitialization {
    private Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(2));
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

    public LoginPageEpam(WebDriver driver) {
        super(driver);
    }
    public String getUserInfoName() {
        return userInfoName.getText();
    }
    public void logoutTraining() throws InterruptedException {
        userMenu.click();
        Thread.sleep(3);
        userLogout.click();
    }
    public TrainingListPageEpam pssToTrainingListPageEpam() {
        wait.until(ExpectedConditions.visibilityOf(titlTrainingList));
        titlTrainingList.click();
        return new TrainingListPageEpam(driver);
    }
    public NewsPageEpam passToNewsPageEpam() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(titleNews));
        titleNews.click();
        return new NewsPageEpam(driver);
    }
}
