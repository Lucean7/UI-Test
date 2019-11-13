package testTrainigPageEpam;

import core.PageFactoryInitialization;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrainingHomePageEpam extends PageFactoryInitialization{

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

    //@FindBy(xpath = "//div[@class='location-selector__globe']")
    //private  WebElement slectorLanguageMenu;
    //@FindBy(xpath = "//a[contains(text(),'English')]")
    //private  WebElement selectortEnglish;

    public TrainingHomePageEpam(WebDriver driver) {
        super(driver);
    }
    public void clickSingIn(){
        singIn.click();
    }
    public void signInEmailPassword(String mail, String password) throws InterruptedException {
        signInEmail.sendKeys(mail);
        signInPassword.sendKeys(password);
    }
    public String getMessageFailed(){
        signInGo.click();
        return incorrectLogin.getText();
    }
    public LoginPageEpam passToLoginPageEpam(){
        signInGo.click();
        return new LoginPageEpam(driver);
    }
    public void titleCloseClick() {
        titleClose.click();
    }
}
