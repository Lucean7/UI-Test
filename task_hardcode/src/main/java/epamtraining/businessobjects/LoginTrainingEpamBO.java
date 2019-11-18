package epamtraining.businessobjects;

import epamtraining.core.AbstractPageObject;
import epamtraining.pageobject.LoginTrainingEpam;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginTrainingEpamBO extends AbstractPageObject {
    private LoginTrainingEpam loginTrainingEpam;

    public LoginTrainingEpamBO(WebDriver driver) {
        super(driver);
        this.loginTrainingEpam = initLoginTrainingEpam();
    }

    private LoginTrainingEpam initLoginTrainingEpam(){
        return new LoginTrainingEpam(driver);
    }

    public LoginTrainingEpamBO isUserInfoName(String name) {
        Assert.assertEquals(name,
                fwait.until(ExpectedConditions.elementToBeClickable(loginTrainingEpam.getUserInfoName())).getText(),
                "Incorrect work.");
        return this;
    }
    public LoginTrainingEpamBO logoutTrainingBO() {
        fwait.until(ExpectedConditions.elementToBeClickable(loginTrainingEpam.getUserMenu())).click();
        fwait.until(ExpectedConditions.elementToBeClickable(loginTrainingEpam.getUserLogout())).click();
        return this;
    }
    public TrainingListEpamBO passToTrainingListEpamBO() {
        fwait.until(ExpectedConditions.elementToBeClickable(loginTrainingEpam.getTitlTrainingList())).click();
        return new TrainingListEpamBO(driver);
    }
    public FAQEpamBO passToFAQEpamBO() {
        fwait.until(ExpectedConditions.elementToBeClickable(loginTrainingEpam.getTitlFAQ())).click();
        return new FAQEpamBO(driver);
    }
    public NewsEpamBO passToNewsEpamBO(){
        fwait.until(ExpectedConditions.elementToBeClickable(loginTrainingEpam.getTitleNews())).click();
        return new NewsEpamBO(driver);
    }
    public AboutEpamBO passToAboutEpamBO(){
        fwait.until(ExpectedConditions.elementToBeClickable(loginTrainingEpam.getTitleAbout())).click();
        return new AboutEpamBO(driver);
    }

}
