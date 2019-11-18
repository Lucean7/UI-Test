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
    public TrainingListEpam getTrainingListEpam() {
        return trainingListEpam;
    }

    public TrainingListEpamBO scrollTo(WebElement webElement){
        js.executeScript("arguments[0].scrollIntoView(true);",webElement);
        return this;
    }
    public TrainingListEpamBO pressButton(WebElement button){
        fwait.until(ExpectedConditions.elementToBeClickable(button)).click();
        return this;
    }
    public TrainingListEpamBO isSkillsExist(WebElement skills){
        try {
            skills.isDisplayed();
        }catch (NoSuchElementException e){
            System.out.println("Skills doesn't exist.");
        }
        return this;
    }
    public TrainingListEpamBO inputInBox(WebElement searchElement, String s){
        fwait.until(ExpectedConditions.elementToBeClickable(searchElement))
                .sendKeys(s);
        return this;
    }
    public TrainingListEpamBO noSkills(WebElement webElement, String s){
        Assert.assertFalse(webElement.getText().contains(s),"Incorrect work. Skills "+s+" exist.");
        return this;
    }
    public TrainingListEpamBO isSearchResultsReturned(List<WebElement>tableLinkT) {
        List<WebElement> tableLink = tableLinkT; ;
        Assert.assertTrue(tableLink.size()!=0,"No results found for this search.");
        return this;
    }


}
