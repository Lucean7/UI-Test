import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testTrainigPageEpam.LoginPageEpam;
import testTrainigPageEpam.NewsPageEpam;
import testTrainigPageEpam.TrainingHomePageEpam;
import testTrainigPageEpam.TrainingListPageEpam;

import static core.EnvironmentsURL.getPathTraining;
import static core.WebDriverInitialization.getWebDriver;

public class HardCodeTask {
    private WebDriver driver;
    private TrainingHomePageEpam trainingHomePageEpam;
    private LoginPageEpam loginPageEpam;
    private NewsPageEpam newsPageEpam;
    private TrainingListPageEpam trainingListPageEpam;

    @BeforeTest
    public void openSite(){
        driver = getWebDriver();
        driver.get(getPathTraining());
    }
    @AfterTest
    public void closeSite(){
      driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        trainingHomePageEpam = new TrainingHomePageEpam(driver);
        trainingHomePageEpam.clickSingIn();
        trainingHomePageEpam.signInEmailPassword("lucean7@gmail.com", "zdfhafh");
        loginPageEpam = trainingHomePageEpam.passToLoginPageEpam();
        Assert.assertEquals(loginPageEpam.getUserInfoName(), "Viktor Pavlyshyn", "Login successful!");
        loginPageEpam.logoutTraining();
    }
    @Test
    public void test2() throws InterruptedException {
        trainingHomePageEpam = new TrainingHomePageEpam(driver);
        trainingHomePageEpam.clickSingIn();
        trainingHomePageEpam.signInEmailPassword("rhhERH@gmail.com", "AHERAER");
        Assert.assertEquals(trainingHomePageEpam.getMessageFailed(),"Ошибка авторизации. Пожалуйста, попробуйте еще раз.","Login failed. Please try again.");
        trainingHomePageEpam.titleCloseClick();
    }
    @Test(enabled = false)
    public void test3() throws InterruptedException {
        trainingHomePageEpam = new TrainingHomePageEpam(driver);
        trainingHomePageEpam.clickSingIn();
        trainingHomePageEpam.signInEmailPassword("lucean7@gmail.com", "zdfhhz");
        loginPageEpam = trainingHomePageEpam.passToLoginPageEpam();
        trainingListPageEpam = loginPageEpam.pssToTrainingListPageEpam();
        trainingListPageEpam.scrollToTrainings("scrollBy (0, 750)");
        trainingListPageEpam.arroIconDownClick();
        trainingListPageEpam.bySkillsClick();
        trainingListPageEpam.skillsJavaClick();
        trainingListPageEpam.arrowIconRotateClick();
        trainingListPageEpam.deleteLocationClick();
        Assert.assertTrue(trainingListPageEpam.skillsJavaExist(),"Java not found!");
        trainingListPageEpam.skillsJavaDeletClick();
        trainingListPageEpam.arroIconDownClick();
        trainingListPageEpam.dataScienceClick();
        trainingListPageEpam.dataEngineeringClick();
        trainingListPageEpam.arrowIconRotateClick();
        Assert.assertTrue(trainingListPageEpam.skillsDataExist(),"Data not found!");
        trainingListPageEpam.skillsJavaDeletClick();
        trainingListPageEpam.arroIconDownClick();
        trainingListPageEpam.inputSearchBoxClick("Pascal");
        Assert.assertFalse(trainingListPageEpam.getTableOfSkills(),"Search results for that Pascal!");
        loginPageEpam.logoutTraining();
    }
    @Test(enabled = false)
    public void test4() throws InterruptedException {
        trainingHomePageEpam = new TrainingHomePageEpam(driver);
        trainingHomePageEpam.clickSingIn();
        trainingHomePageEpam.signInEmailPassword("lucean7@gmail.com", "zdfhzd");
        loginPageEpam = trainingHomePageEpam.passToLoginPageEpam();
        newsPageEpam = loginPageEpam.passToNewsPageEpam();
        Assert.assertTrue(newsPageEpam.displayedNews(),"News link isn't displayed.");
        Assert.assertTrue(newsPageEpam.displayedSuccessStories(),"Success Stories link isn't displayed.");
        Assert.assertTrue(newsPageEpam.displayedMaterials(),"Materials link isn't displayed.");
        Assert.assertTrue(newsPageEpam.displayedVideos(),"Videos link isn't displayed.");
        Assert.assertTrue(newsPageEpam.checkExistWord(),"Not all result links contain word ‘materials’ or ‘useful’");
        loginPageEpam.logoutTraining();

    }
    @Test
    public void test5() throws InterruptedException {
        trainingHomePageEpam = new TrainingHomePageEpam(driver);
        trainingHomePageEpam.clickSingIn();
        trainingHomePageEpam.signInEmailPassword("lucean7@gmail.com", "zdhdfdfh");
        loginPageEpam = trainingHomePageEpam.passToLoginPageEpam();
        trainingListPageEpam = loginPageEpam.pssToTrainingListPageEpam();
        trainingListPageEpam.scrollToTrainings("scrollBy (0, 1000)");
        trainingListPageEpam.deleteLocationClick();
        trainingListPageEpam.searchBoxClick();
        trainingListPageEpam.selectLocation();
        trainingListPageEpam.selectUkraine();
        trainingListPageEpam.selectLviv();
        trainingListPageEpam.arrowIconRotateClick();
        Assert.assertTrue(trainingListPageEpam.checkSearchResulted(),"No results found for this search.");
        loginPageEpam.logoutTraining();
    }

}
