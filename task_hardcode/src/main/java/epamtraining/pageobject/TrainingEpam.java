package epamtraining.pageobject;

import epamtraining.core.AbstractPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


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

    public WebElement getSingIn() {
        return singIn;
    }

    public WebElement getSignInEmail() {
        return signInEmail;
    }

    public WebElement getSignInPassword() {
        return signInPassword;
    }

    public WebElement getSignInGo() {
        return signInGo;
    }

    public WebElement getIncorrectLogin() {
        return incorrectLogin;
    }

    public WebElement getTitleClose() {
        return titleClose;
    }

    public WebElement getToHome() {
        return toHome;
    }
}