package epamtraining.businessobjects;

import epamtraining.core.AbstractPageObject;

import epamtraining.pageobject.TrainingEpam;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class TrainingEpamBO extends AbstractPageObject {
    private TrainingEpam trainingEpam;

    public TrainingEpamBO(WebDriver driver) {
        super(driver);
        this.trainingEpam = initTrainingEpam();
    }
    private TrainingEpam initTrainingEpam(){
        return new TrainingEpam(driver);
    }

    public TrainingEpam getTrainingEpam() {
        return trainingEpam;
    }

    public TrainingEpamBO signInEmailPassword(String mail, String password){
        fwait.until(ExpectedConditions.elementToBeClickable(trainingEpam.getSingIn())).click();
        fwait.until(ExpectedConditions.elementToBeClickable(trainingEpam.getSignInEmail())).sendKeys(mail);
        fwait.until(ExpectedConditions.elementToBeClickable(trainingEpam.getSignInPassword())).sendKeys(password);
        fwait.until(ExpectedConditions.elementToBeClickable(trainingEpam.getSignInGo())).click();
        return this;
    }
    public TrainingEpamBO getMessageFailed(){
        fwait.until(ExpectedConditions.elementToBeClickable(trainingEpam.getSignInGo())).click();
        Assert.assertEquals(fwait.until(ExpectedConditions.elementToBeClickable(trainingEpam.getIncorrectLogin())).getText(),
                "Ошибка авторизации. Пожалуйста, попробуйте еще раз.",
                "Incorrect work");//"Login failed. Please try again."
        return this;
    }
    public LoginTrainingEpamBO passToLoginPageEpamBO(){
        return new LoginTrainingEpamBO(driver);
    }
    public TrainingEpamBO pressButton(WebElement webElement) {
        fwait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
        return this;
    }

}
