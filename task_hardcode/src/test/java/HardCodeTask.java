import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import testTrainigPageEpam.*;

import static core.EnvironmentsURL.getPathTraining;
import static core.EnvironmentsURL.getUserMail;
import static core.EnvironmentsURL.getUserPassword;
import static core.InitialWebDriver.getWebDriver;


public class HardCodeTask {
    private WebDriver driver;
    private TrainingEpam trainingEpam;
    private LoginTrainingEpam loginTrainingEpam;
    private NewsEpam newsEpam;
    private TrainingListEpam trainingListEpam;

    @BeforeMethod
    public void openSite(){
        driver = getWebDriver();//getInstans();
        driver.get(getPathTraining("linkTraining.path","config.pathsite.properties"));
        trainingEpam = new TrainingEpam(driver);
    }

    @AfterMethod
    public void closeSite(){
        driver.quit();
    }

    @Test
    public void verifyLoginWithAppropriateCredentials() throws InterruptedException {
        trainingEpam.signInEmailPassword(getUserMail("mailTrue","config.userdata.properties"),
                        getUserPassword("passwordTrue","config.userdata.properties"));
        loginTrainingEpam = trainingEpam.passToLoginPageEpam()
                .getUserInfoName("Viktor Pavlyshyn")
                .logoutTraining();
    }
    @Test
    public void VerifyLoginWithIncorrectCredentials() throws InterruptedException {
        trainingEpam = new TrainingEpam(driver)
                .signInEmailPassword(getUserMail("mailFalse","config.userdata.properties"),
                        getUserPassword("passwordFalse","config.userdata.properties"))
                .getMessageFailed()
                .titleCloseClick();
    }
    @Test
    public void VerifyTrainingsSearch() throws InterruptedException {
        trainingEpam = new TrainingEpam(driver)
                .signInEmailPassword(getUserMail("mailTrue","config.userdata.properties"),
                        getUserPassword("passwordTrue","config.userdata.properties"));
        loginTrainingEpam = trainingEpam.passToLoginPageEpam();
        trainingListEpam = loginTrainingEpam.passToTrainingListEpam()
                .scrollTo("window.scrollTo(0, 900)")
                .arrowIconDownClick()
                .bySkillsClick()
                .skillsJavaClick()
                .arrowIconRotateClick()
                .deleteLocationClick()
                .skillsJavaExist()
                .skillsJavaDeletClick()
                .arrowIconDownClick()
                .dataClick()
                .arrowIconRotateClick()
                .skillsDataExist()
                .skillsJavaDeletClick()
                .arrowIconDownClick()
                .inputSearchBoxClick("Pascal")
                .skillsPascalExist();
        loginTrainingEpam.logoutTraining();
    }
    @Test
    public void VerifyNewsPage() throws InterruptedException {
        trainingEpam = new TrainingEpam(driver)
                .signInEmailPassword(getUserMail("mailTrue","config.userdata.properties"),
                        getUserPassword("passwordTrue","config.userdata.properties"));
        loginTrainingEpam = trainingEpam.passToLoginPageEpam();
        newsEpam = loginTrainingEpam.passToNewsEpam()
                .isDisplayedNews().isDisplayedSuccessStories()
                .isDisplayedMaterials().isDisplayedVideos()
                .isAllLinksMaterialContains("materials","useful");
        loginTrainingEpam.logoutTraining();
    }
    @Test
    public void VerifyTrainings() throws InterruptedException {
        trainingEpam = new TrainingEpam(driver)
                .signInEmailPassword(getUserMail("mailTrue","config.userdata.properties"),
                        getUserPassword("passwordTrue","config.userdata.properties"));
        loginTrainingEpam = trainingEpam.passToLoginPageEpam();
        trainingListEpam = loginTrainingEpam.passToTrainingListEpam()
                .scrollTo("scrollBy (0, 1000)")
                .deleteLocationClick()
                .searchBoxClick()
                .selectLocation()
                .selectUkraine()
                .selectLviv()
                .arrowIconRotateClick()
                .isSearchResultsReturned();
        loginTrainingEpam.logoutTraining();
    }
    @Test
    public void VerifyFAQ() throws InterruptedException {
        trainingEpam = new TrainingEpam(driver)
                .signInEmailPassword(getUserMail("mailTrue","config.userdata.properties"),
                        getUserPassword("passwordTrue","config.userdata.properties"));
        loginTrainingEpam = trainingEpam.passToLoginPageEpam();
        FAQEpam faqEpam = loginTrainingEpam.passToFAQEpam();
        faqEpam.scrollTo("arguments[0].scrollIntoView(true);", faqEpam.getHомеText())
                .isfirstSentenceContains("Technical education is not obligatory, but desirable. Detailed required skills are specified in each training.");
        loginTrainingEpam.logoutTraining();
    }
    @Test
    public void VerifyAbout() throws InterruptedException {
        trainingEpam = new TrainingEpam(driver)
                .signInEmailPassword(getUserMail("mailTrue","config.userdata.properties"),
                        getUserPassword("passwordTrue","config.userdata.properties"));
        loginTrainingEpam = trainingEpam.passToLoginPageEpam();
        AboutEpam aboutEpam = loginTrainingEpam.passToAboutEpam()
                .scrollTo("window.scrollTo(0, 1600)")
                .mapUkraineClick()
                .isAddressOfLviv("Shevchenka str. 111a");
        loginTrainingEpam.logoutTraining();
    }
}