package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customelistener.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
public class DurationOfStayPage extends Utility {
    /*
    nextStepButton, lessThanSixMonths, moreThanSixMonths locators and create methods
  'void selectLengthOfStay(String moreOrLess)' (Note: use switch statement for select moreOrLess stay) and
  'void clickNextStepButton()'
     */

@CacheLookup
    @FindBy (xpath = "//button[contains(text(),'Continue')]")
WebElement nextStepButton;

public void clickNextStepButton(){
    clickOnElement(nextStepButton);
    Reporter.log("click on next step" + nextStepButton.toString());
    CustomListeners.test.log(Status.PASS,"click on next " + nextStepButton);
}

@CacheLookup
    @FindBy(xpath = "//div[@class='govuk-radios']/div[1]")
    WebElement lessThanSixMonths;

@CacheLookup
    @FindBy(xpath = "//div[@class='govuk-radios']/div[2]")
    WebElement moreThanSixMonths;

    public void selectLengthOfStay(String moreOrLess) {
        switch (moreOrLess.toLowerCase()) {
            case "more":
                moreThanSixMonths.click();
                break;
            case "less":
                lessThanSixMonths.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + moreOrLess);
        }

//public void selectLengthOfStay(String moreOrLess ){
//    switch (moreOrLess.toLowerCase()) {
//        case "less":
//            driver.findElement((By) lessThanSixMonths).click();
//            break;
//        case "more":
//            driver.findElement((By) moreThanSixMonths).click();
//            break;
//        default:
//            throw new IllegalArgumentException("Invalid option: " + moreOrLess);
//    }
}


}
