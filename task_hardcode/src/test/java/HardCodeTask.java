import core.InitialWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import testTrainigPageEpam.*;

import static core.EnvironmentsURL.getPathTraining;
import static core.EnvironmentsURL.getUserMail;
import static core.EnvironmentsURL.getUserPassword;


public class HardCodeTask {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void openSite(){
        driver = InitialWebDriver.getInstans();
        driver.get(getPathTraining("linkTraining.path","config.pathsite.properties"));
    }

    @AfterMethod(alwaysRun = true)
    public void closeSite(){
        InitialWebDriver.closeDriver();
    }

    @Test
    public void verifyLoginWithAppropriateCredentials() throws InterruptedException {
        TrainingEpam trainingEpam = new TrainingEpam(driver)
                .signInEmailPassword(getUserMail("mailTrue","config.userdata.properties"),
                        getUserPassword("passwordTrue","config.userdata.properties"));
        trainingEpam.passToLoginPageEpam()
                .getUserInfoName("Viktor Pavlyshyn");
    }
    @Test
    public void VerifyLoginWithIncorrectCredentials() throws InterruptedException {
        TrainingEpam trainingEpam = new TrainingEpam(driver)
                .signInEmailPassword(getUserMail("mailFalse","config.userdata.properties"),
                        getUserPassword("passwordFalse","config.userdata.properties"))
                .getMessageFailed()
                .titleCloseClick();
    }
    @Test
    public void VerifyTrainingsSearch() throws InterruptedException {
        TrainingEpam trainingEpam = new TrainingEpam(driver)
                .signInEmailPassword(getUserMail("mailTrue","config.userdata.properties"),
                        getUserPassword("passwordTrue","config.userdata.properties"));
        trainingEpam.passToLoginPageEpam()
                .passToTrainingListEpam()
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
    }
    @Test
    public void verifyNewsPage() throws InterruptedException {
        TrainingEpam trainingEpam = new TrainingEpam(driver)
                .signInEmailPassword(getUserMail("mailTrue","config.userdata.properties"),
                        getUserPassword("passwordTrue","config.userdata.properties"));
        trainingEpam.passToLoginPageEpam()
                .passToNewsEpam()
                .isDisplayedNews().isDisplayedSuccessStories()
                .isDisplayedMaterials().isDisplayedVideos()
                .isAllLinksMaterialContains("materials","useful");
    }
    @Test
    public void verifyTrainings() throws InterruptedException {
        TrainingEpam trainingEpam = new TrainingEpam(driver)
                .signInEmailPassword(getUserMail("mailTrue","config.userdata.properties"),
                        getUserPassword("passwordTrue","config.userdata.properties"));
        trainingEpam.passToLoginPageEpam()
                .passToTrainingListEpam()
                .scrollTo("scrollBy (0, 1000)")
                .deleteLocationClick()
                .searchBoxClick()
                .selectLocation()
                .selectUkraine()
                .selectLviv()
                .arrowIconRotateClick()
                .isSearchResultsReturned();
    }
    @Test
    public void verifyFAQ() throws InterruptedException {
        TrainingEpam trainingEpam = new TrainingEpam(driver)
                .signInEmailPassword(getUserMail("mailTrue","config.userdata.properties"),
                        getUserPassword("passwordTrue","config.userdata.properties"));
        LoginTrainingEpam loginTrainingEpam = trainingEpam.passToLoginPageEpam();
        FAQEpam faqEpam = loginTrainingEpam.passToFAQEpam();
        faqEpam.scrollTo("arguments[0].scrollIntoView(true);", faqEpam.getHомеText())
                .isfirstSentenceContains("Technical education is not obligatory, but desirable. Detailed required skills are specified in each training.");
    }
    @Test
    public void verifyAbout() throws InterruptedException {
        TrainingEpam trainingEpam = new TrainingEpam(driver)
                .signInEmailPassword(getUserMail("mailTrue","config.userdata.properties"),
                        getUserPassword("passwordTrue","config.userdata.properties"));
        LoginTrainingEpam loginTrainingEpam = trainingEpam.passToLoginPageEpam();
        AboutEpam aboutEpam = loginTrainingEpam.passToAboutEpam()
                .scrollTo("window.scrollTo(0, 1600)")
                .mapUkraineClick()
                .isAddressOfLviv("Shevchenka str. 111a");
    }
}