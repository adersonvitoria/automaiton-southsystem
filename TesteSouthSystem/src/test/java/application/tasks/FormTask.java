package application.tasks;

import org.openqa.selenium.WebDriver;
import application.objects.FormObject;

public class FormTask {
    private FormObject dataForm;

    public FormTask(WebDriver driver){
        this.dataForm = new FormObject(driver);
    }
    public void selectProfile(){
        this.dataForm.selectUserProfileForYou().click();
    }
    public void enterValueToApply(String Value){
        this.dataForm.whatAmountDoYouWantToApply().sendKeys(Value);
    }
    public void enterValueToSave(String Value){
        this.dataForm.howMuchDoYouWantToSaveEveryMonth().sendKeys(Value);
    }
    public void  howMuchDoYouWantToSaveEveryMonth(String Value){
        this.dataForm.howLongDoYouWantToSave().sendKeys(Value);
    }
    public void  selectMonths(){
        this.dataForm.howLongDoYouWantToSaveSelectMonths().click();
    }
    public void  clickOnTheSimulateButton(){
        this.dataForm.simulateButton().click();
    }
    public String getTextMsgMinValue(){
        return this.dataForm.msgValueMin20().getText();
    }
    public String getTextSimulationForm(){
        return this.dataForm.msgSimulationForm().getText();
    }
}
