package testTrainigPageEpam;

import core.AbstractPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TrainingEpam extends AbstractPageObject {

    @FindBy(xpath = "//p[@class='header-auth__signin']")
    private WebElement singIn;
    @FindBy(xpath = "//input[@id='signInEmail']" )
    private WebElement signInEmail;
    @FindBy(xpath = "//input[@id='signInPassword']")
    private WebElement signInPassword;
    @FindBy(xpath = "//input[@class='popup-reg-sign-in-form__sign-in']")
    private WebElement signInGo;
    @FindBy(xpath = "//div[@class='popup__error-message ng-binding']")
    private  WebElement incorrectLogin;
    @FindBy(xpath = "//div[@class='popup-title__close']")
    private  WebElement titleClose;
    @FindBy(xpath = "//a[@class='logo logo--epam']")
    private  WebElement toHome;


    public TrainingEpam(WebDriver driver) {
        super(driver);
    }
    public TrainingEpam signInEmailPassword(String mail, String password) throws InterruptedException {
        singIn.click();
        signInEmail.sendKeys(mail);
        signInPassword.sendKeys(password);
        signInGo.click();
        return this;
    }
    public TrainingEpam getMessageFailed(){
        signInGo.click();
        Assert.assertEquals(incorrectLogin.getText(), "Ошибка авторизации. Пожалуйста, попробуйте еще раз.",
                "Incorrect work");//"Login failed. Please try again."
        return this;
    }
    public LoginTrainingEpam passToLoginPageEpam(){
        signInGo.click();
        return new LoginTrainingEpam(driver);
    }
    public TrainingEpam titleCloseClick() {
        titleClose.click();
        return this;
    }


    public TrainingEpam homeClick() {
        toHome.click();
        return this;
    }
}