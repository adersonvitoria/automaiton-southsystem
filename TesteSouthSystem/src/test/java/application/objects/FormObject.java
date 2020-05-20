package application.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormObject {
    private WebDriver driver;

    public FormObject(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement selectUserProfileForYou() {
        return this.driver.findElement(By.xpath("//input[contains(@value,'paraVoce')]"));
    }
    public WebElement selectTheUserProfileForYourCompanyOrAgribusiness() {
        return this.driver.findElement(By.xpath("//input[contains(@value,'paraEmpresa')]"));
    }
    public WebElement whatAmountDoYouWantToApply() {
        return this.driver.findElement(By.xpath("//input[contains(@name,'valorAplicar')]"));
    }
    public WebElement howMuchDoYouWantToSaveEveryMonth() {
        return this.driver.findElement(By.xpath("//input[contains(@name,'valorInvestir')]"));
    }
    public WebElement howLongDoYouWantToSave() {
        return this.driver.findElement(By.xpath("//input[contains(@name,'tempo')]"));
    }
    public WebElement howLongDoYouWantToSaveSelectMonths() {
        this.driver.findElement(By.xpath("//a[@class='btSelect'][contains(.,'Meses')]")).click();
        return this.driver.findElement(By.xpath("//a[contains(@rel,'M')]"));
    }
    public WebElement howLongDoYouWantToSaveSelectYears() {
        this.driver.findElement(By.xpath("//a[@class='btSelect'][contains(.,'Meses')]")).click();
        return this.driver.findElement(By.xpath("//a[contains(@rel,'A')]"));
    }
    public WebElement simulateButton() {
        return this.driver.findElement(By.xpath("//button[@type='submit'][contains(.,'Simular')]"));
    }
    public WebElement msgValueMin20() {
        return this.driver.findElement(By.id("valorInvestir-error"));
    }
    public WebElement msgSimulationForm() {
        return this.driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/div[2]/div[1]/span"));
    }
}







