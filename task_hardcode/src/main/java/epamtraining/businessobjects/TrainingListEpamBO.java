package epamtraining.businessobjects;

import epamtraining.core.AbstractPageObject;
import epamtraining.pageobject.TrainingListEpam;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.NoSuchElementException;

public class TrainingListEpamBO extends AbstractPageObject {
    private TrainingListEpam trainingListEpam;

    public TrainingListEpamBO(WebDriver driver) {
        super(driver);
        this.trainingListEpam = initTrainingListEpam();
    }

    private TrainingListEpam initTrainingListEpam(){
        return new TrainingListEpam(driver);
    }

    public TrainingListEpamBO scrollToTrainings(){
        js.executeScript("arguments[0].scrollIntoView(true);",
                trainingListEpam.getYellowInfoBanner());
        return this;
    }

    public TrainingListEpamBO selectSkillsByLocationLviv(){
        fwait.until(ExpectedConditions.elementToBeClickable(trainingListEpam.getDeleteLocation())).click();
        fwait.until(ExpectedConditions.elementToBeClickable(trainingListEpam.getSearchBox())).click();
        fwait.until(ExpectedConditions.elementToBeClickable(trainingListEpam.getSelectLocation())).click();
        fwait.until(ExpectedConditions.elementToBeClickable(trainingListEpam.getSelectUkraine())).click();
        fwait.until(ExpectedConditions.elementToBeClickable(trainingListEpam.getSelectLiviv())).click();
        fwait.until(ExpectedConditions.elementToBeClickable(trainingListEpam.getArrowIconRotate())).click();
        return this;
    }

    public TrainingListEpamBO selectAllJavaSkills(){
        fwait.until(ExpectedConditions.elementToBeClickable(trainingListEpam.getSearchBox())).click();
        fwait.until(ExpectedConditions.elementToBeClickable(trainingListEpam.getBySkills())).click();
        fwait.until(ExpectedConditions.elementToBeClickable(trainingListEpam.getSkillsJava())).click();
        fwait.until(ExpectedConditions.elementToBeClickable(trainingListEpam.getArrowIconRotate())).click();
        fwait.until(ExpectedConditions.elementToBeClickable(trainingListEpam.getDeleteLocation())).click();
        return this;
    }

    public TrainingListEpamBO selectAllDataSkills(){
        fwait.until(ExpectedConditions.elementToBeClickable(trainingListEpam.getSkillsdelet())).click();
        fwait.until(ExpectedConditions.elementToBeClickable(trainingListEpam.getArroIconDown())).click();
        fwait.until(ExpectedConditions.elementToBeClickable(trainingListEpam.getDataScience())).click();
        fwait.until(ExpectedConditions.elementToBeClickable(trainingListEpam.getDataEngineering())).click();
        fwait.until(ExpectedConditions.elementToBeClickable(trainingListEpam.getArrowIconRotate())).click();
        return this;
    }

    public TrainingListEpamBO isSkillsJavaExist(){
        try {
            trainingListEpam.getSkillsJavaExist().isDisplayed();
        }catch (NoSuchElementException e){
            System.out.println("Skills doesn't exist.");
        }
        return this;
    }

    public TrainingListEpamBO isSkillsDataExist(){
        try {
            trainingListEpam.getSkillsDataExist().isDisplayed();
        }catch (NoSuchElementException e){
            System.out.println("Skills doesn't exist.");
        }
        return this;
    }

    public TrainingListEpamBO sendPascalInBox(){
        fwait.until(ExpectedConditions.elementToBeClickable(trainingListEpam.getSkillsdelet())).click();
        fwait.until(ExpectedConditions.elementToBeClickable(trainingListEpam.getArroIconDown())).click();
        fwait.until(ExpectedConditions.elementToBeClickable(trainingListEpam.getSearchBox()))
                .sendKeys("Pascal");
        return this;
    }

    public TrainingListEpamBO isSkillsNotExict(String s){
        Assert.assertFalse(trainingListEpam.getTableOfSkills().getText().contains(s),"Incorrect work. Skills "+s+" exist.");
        return this;
    }

    public TrainingListEpamBO isSearchResultsReturned() {
        List<WebElement> tableLink = trainingListEpam.getTableLinkT(); ;
        Assert.assertTrue(tableLink.size()!=0,"No results found for this search.");
        return this;
    }


}
