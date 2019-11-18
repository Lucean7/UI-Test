import epamtraining.businessobjects.*;
import epamtraining.core.InitialWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static epamtraining.core.EnvironmentsURL.getPathTraining;
import static epamtraining.core.EnvironmentsURL.getUserMail;
import static epamtraining.core.EnvironmentsURL.getUserPassword;


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
        TrainingEpamBO trainingEpamBO = new TrainingEpamBO(driver)
                .signInEmailPassword(getUserMail("mailTrue","config.userdata.properties"),
                        getUserPassword("passwordTrue","config.userdata.properties"));
        trainingEpamBO.passToLoginPageEpamBO()
                .isUserInfoName("Viktor Pavlyshyn");
    }
    @Test
    public void verifyLoginWithIncorrectCredentials() throws InterruptedException {
        TrainingEpamBO trainingEpamBO = new TrainingEpamBO(driver)
                .signInEmailPassword(getUserMail("mailFalse","config.userdata.properties"),
                        getUserPassword("passwordFalse","config.userdata.properties"));
        trainingEpamBO.getMessageFailed()
                .pressButton(trainingEpamBO.getTrainingEpam().getTitleClose());
    }
    @Test
    public void verifyTrainingsSearch() throws InterruptedException {
        TrainingEpamBO trainingEpamBO = new TrainingEpamBO(driver)
                .signInEmailPassword(getUserMail("mailTrue","config.userdata.properties"),
                        getUserPassword("passwordTrue","config.userdata.properties"));
        TrainingListEpamBO trainingListEpamBO = trainingEpamBO.passToLoginPageEpamBO().passToTrainingListEpamBO();
        trainingListEpamBO.scrollTo(trainingListEpamBO.getTrainingListEpam().getYellowInfoBanner())
        .pressButton(trainingListEpamBO.getTrainingListEpam().getArroIconDown())
        .pressButton(trainingListEpamBO.getTrainingListEpam().getBySkills())
        .pressButton(trainingListEpamBO.getTrainingListEpam().getSkillsJava())
        .pressButton(trainingListEpamBO.getTrainingListEpam().getArrowIconRotate())
        .pressButton(trainingListEpamBO.getTrainingListEpam().getDeleteLocation())
        .isSkillsExist(trainingListEpamBO.getTrainingListEpam().getSkillsJavaExist())
        .pressButton(trainingListEpamBO.getTrainingListEpam().getSkillsdelet())
        .pressButton(trainingListEpamBO.getTrainingListEpam().getArroIconDown())
        .pressButton(trainingListEpamBO.getTrainingListEpam().getDataScience())
        .pressButton(trainingListEpamBO.getTrainingListEpam().getDataEngineering())
        .pressButton(trainingListEpamBO.getTrainingListEpam().getArrowIconRotate())
        .isSkillsExist(trainingListEpamBO.getTrainingListEpam().getSkillsDataExist())
        .pressButton(trainingListEpamBO.getTrainingListEpam().getSkillsdelet())
        .pressButton(trainingListEpamBO.getTrainingListEpam().getArroIconDown())
        .inputInBox(trainingListEpamBO.getTrainingListEpam().getSearchBox(),"Pascal")
        .noSkills(trainingListEpamBO.getTrainingListEpam().getTableOfSkills(),"Pascal");

    }
    @Test
    public void verifyNewsPage() throws InterruptedException {
        TrainingEpamBO trainingEpamBO = new TrainingEpamBO(driver)
                .signInEmailPassword(getUserMail("mailTrue","config.userdata.properties"),
                        getUserPassword("passwordTrue","config.userdata.properties"));
        NewsEpamBO newsEpamBO = trainingEpamBO.passToLoginPageEpamBO().passToNewsEpamBO();
        newsEpamBO.isDisplayed(newsEpamBO.getNewsEpam().getVideosTitle(),"Videos Title")
                .isDisplayed(newsEpamBO.getNewsEpam().getMaterialsTitle(),"Materials Title")
                .isDisplayed(newsEpamBO.getNewsEpam().getSuccessStoriesTitle(),"Success Stories Title")
                .isDisplayed(newsEpamBO.getNewsEpam().getNewsTitle(),"News Title")
                .isLinksContains(newsEpamBO.getNewsEpam().getMaterialsTitle(),
                        newsEpamBO.getNewsEpam().getLinkTitleMaterial(),
                        "materials", "useful");
    }
    @Test
    public void verifyTrainings() throws InterruptedException {
        TrainingEpamBO trainingEpamBO = new TrainingEpamBO(driver)
                .signInEmailPassword(getUserMail("mailTrue","config.userdata.properties"),
                        getUserPassword("passwordTrue","config.userdata.properties"));
        TrainingListEpamBO trainingListEpamBO = trainingEpamBO.passToLoginPageEpamBO().passToTrainingListEpamBO();
        trainingListEpamBO.scrollTo(trainingListEpamBO.getTrainingListEpam().getYellowInfoBanner())
                .pressButton(trainingListEpamBO.getTrainingListEpam().getDeleteLocation())
                .pressButton(trainingListEpamBO.getTrainingListEpam().getSearchBox())
                .pressButton(trainingListEpamBO.getTrainingListEpam().getSelectLocation())
                .pressButton(trainingListEpamBO.getTrainingListEpam().getSelectUkraine())
                .pressButton(trainingListEpamBO.getTrainingListEpam().getSelectLiviv())
                .pressButton(trainingListEpamBO.getTrainingListEpam().getArrowIconRotate())
                .isSearchResultsReturned(trainingListEpamBO.getTrainingListEpam().getTableLinkT());
    }
    @Test
    public void verifyFAQ() throws InterruptedException {
        TrainingEpamBO trainingEpamBO = new TrainingEpamBO(driver)
                .signInEmailPassword(getUserMail("mailTrue","config.userdata.properties"),
                        getUserPassword("passwordTrue","config.userdata.properties"));
        LoginTrainingEpamBO loginTrainingEpamBO = trainingEpamBO.passToLoginPageEpamBO();
        FAQEpamBO faqEpamBO = loginTrainingEpamBO.passToFAQEpamBO();
        faqEpamBO.scrollTo(faqEpamBO.getFaqEpam().getHomeText())
                .isSentenceContains(faqEpamBO.getFaqEpam().getFirstSentence(),faqEpamBO.getFaqEpam().getFirstSentenceText(),
                        "Studying at EPAM Training Center is absolutely free. " +
                                "A group is formed based on the results of selection testing.");
    }
    @Test
    public void verifyAbout() throws InterruptedException {
        TrainingEpamBO trainingEpamBO = new TrainingEpamBO(driver)
                .signInEmailPassword(getUserMail("mailTrue","config.userdata.properties"),
                        getUserPassword("passwordTrue","config.userdata.properties"));
        LoginTrainingEpamBO loginTrainingEpamBO = trainingEpamBO.passToLoginPageEpamBO();
        AboutEpamBO aboutEpamBO = loginTrainingEpamBO.passToAboutEpamBO();
        aboutEpamBO.scrollTo(aboutEpamBO.getAboutEpam().geTtitleWhereWeAre())
                .checkAddress(aboutEpamBO.getAboutEpam().getMapUkraine()
                        ,aboutEpamBO.getAboutEpam().getMapLviv(),
                        aboutEpamBO.getAboutEpam().getAddressOfLviv(),
                        "Shevchenka str. 111a");
    }
}