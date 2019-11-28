import epamtraining.businessobjects.*;
import epamtraining.core.InitialWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static epamtraining.core.EnvironmentsURL.*;

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
    public void verifyLoginWithAppropriateCredentials() {
        TrainingEpamBO trainingEpamBO = new TrainingEpamBO(driver)
                .signInEmailPassword(getUserMail("mailTrue","config.userdata.properties"),
                        getUserPassword("passwordTrue","config.userdata.properties"));
        trainingEpamBO.passToLoginPageEpamBO()
                .isUserInfoName("Viktor Pavlyshyn");
    }
    @Test
    public void verifyLoginWithIncorrectCredentials(){
        TrainingEpamBO trainingEpamBO = new TrainingEpamBO(driver)
                .signInEmailPassword((getUserMail("mailFalse","config.userdata.properties")),
                        getUserPassword("passwordFalse","config.userdata.properties"));
        trainingEpamBO.getMessageFailed()
                .pressButton(trainingEpamBO.getTrainingEpam().getTitleClose());
    }
    @Test
    public void verifyTrainingsSearch() {
        TrainingEpamBO trainingEpamBO = new TrainingEpamBO(driver)
                .signInEmailPassword(getUserMail("mailTrue","config.userdata.properties"),
                        getUserPassword("passwordTrue","config.userdata.properties"));
        TrainingListEpamBO trainingListEpamBO = trainingEpamBO.
                passToLoginPageEpamBO()
                .passToTrainingListEpamBO();
        trainingListEpamBO.scrollToTrainings()
                .selectAllJavaSkills()
                .isSkillsJavaExist()
                .selectAllDataSkills()
                .isSkillsDataExist()
                .sendPascalInBox()
                .isSkillsNotExict("Pascal");
    }
    @Test
    public void verifyNewsPage(){
        TrainingEpamBO trainingEpamBO = new TrainingEpamBO(driver)
                .signInEmailPassword(getUserMail("mailTrue","config.userdata.properties"),
                        getUserPassword("passwordTrue","config.userdata.properties"));
        NewsEpamBO newsEpamBO = trainingEpamBO
                .passToLoginPageEpamBO()
                .passToNewsEpamBO();
        newsEpamBO.isVideosTitleDisplayed()
                .isMaterialsTitleDisplayed()
                .isSuccessStoriesTitleDisplayed()
                .isNewsTitleDisplayed()
                .isLinksMaterialsTitleContains("materials", "useful");
    }
    @Test
    public void verifyTrainings(){
        TrainingEpamBO trainingEpamBO = new TrainingEpamBO(driver)
                .signInEmailPassword(getUserMail("mailTrue","config.userdata.properties"),
                        getUserPassword("passwordTrue","config.userdata.properties"));
        TrainingListEpamBO trainingListEpamBO = trainingEpamBO.
                passToLoginPageEpamBO().
                passToTrainingListEpamBO();
        trainingListEpamBO.scrollToTrainings()
                .selectSkillsByLocationLviv()
                .isSearchResultsReturned();
    }
    @Test
    public void verifyFAQ() {
        TrainingEpamBO trainingEpamBO = new TrainingEpamBO(driver)
                .signInEmailPassword(getUserMail("mailTrue","config.userdata.properties"),
                        getUserPassword("passwordTrue","config.userdata.properties"));
        LoginTrainingEpamBO loginTrainingEpamBO = trainingEpamBO.passToLoginPageEpamBO();
        FAQEpamBO faqEpamBO = loginTrainingEpamBO.passToFAQEpamBO();
        faqEpamBO.scrollToSentenceText()
                .isFAQSentenceContains("Studying at EPAM Training Center is absolutely free. " +
                                "A group is formed based on the results of selection testing.");
    }
    @Test
    public void verifyAbout(){
        TrainingEpamBO trainingEpamBO = new TrainingEpamBO(driver)
                .signInEmailPassword(getUserMail("mailTrue","config.userdata.properties"),
                        getUserPassword("passwordTrue","config.userdata.properties"));
        LoginTrainingEpamBO loginTrainingEpamBO = trainingEpamBO.passToLoginPageEpamBO();
        AboutEpamBO aboutEpamBO = loginTrainingEpamBO.passToAboutEpamBO();
        aboutEpamBO.scrollToMap()
                .checkAddressLvivEpam("Shevchenka str. 111a");
    }
}