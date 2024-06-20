package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customelistener.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class SelectNationalityPage extends Utility {
    /*
    -nationalityDropDownList, nextStepButton locators and create methods  'void selectNationality(String nationality)'
  and 'void clickNextStepButton()'
     */

    @CacheLookup
    @FindBy(xpath = "//select[@id='response']")
    WebElement nationalityDropDownList;

public void selectNationality(String nationality){
    clickOnElement(nationalityDropDownList);
    selectByVisibleTextFromDropDown(nationalityDropDownList,nationality);
    CustomListeners.test.log(Status.PASS,"Select nationality"+nationalityDropDownList);
    Reporter.log("select nationality"+nationalityDropDownList);
}
@CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement  nextStepButton;

public void clickNextStepButton(){
    clickOnElement(nextStepButton);
    Reporter.log("click on continue"+nextStepButton.toString());
    CustomListeners.test.log(Status.PASS,"click on continue"+nextStepButton);
}
}
