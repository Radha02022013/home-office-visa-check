package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customelistener.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class StartPage extends Utility {
    /*
    startNowButton locators and create method 'void clickStartNow()'
     */

@CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Accept additional cookies')]")
    WebElement cookies;

public void clickOnCookies(){
        clickOnElement(cookies);
    }

    @CacheLookup
    @FindBy(xpath = "//body/div[@id='wrapper']/div[1]/main[1]/div[2]/div[1]/article[1]/section[1]/a[1]")
    WebElement startNowButton;

public void clickStartNow(){
    clickOnElement(startNowButton);
    Reporter.log("click on start"+startNowButton.toString());
    CustomListeners.test.log(Status.PASS,"click on start "+startNowButton);
}
}
