package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.customelistener.CustomListeners;
import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class VisaConfirmationTest extends BaseTest {

    StartPage startPage;
    DurationOfStayPage durationOfStayPage;
    FamilyImmigrationStatusPage familyImmigrationStatusPage;
    ReasonForTravelPage reasonForTravelPage;
    ResultPage resultPage;
    SelectNationalityPage selectNationalityPage;
    WorkTypePage workTypePage;


    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        startPage = new StartPage();
        durationOfStayPage = new DurationOfStayPage();
        familyImmigrationStatusPage = new FamilyImmigrationStatusPage();
        resultPage = new ResultPage();
        reasonForTravelPage = new ReasonForTravelPage();
        selectNationalityPage = new SelectNationalityPage();
        workTypePage = new WorkTypePage();

    }

/*
1.anAustralianComingToUKForTourism().
    Click on start button
	Select a Nationality 'Australia'
	Click on Continue button
	Select reason 'Tourism'
	Click on Continue button
	verify result 'You will not need a visa to come to the UK'
 */

    @Test(groups = {"sanity", "regression"}, dataProvider = "AustralianComingToUk", dataProviderClass = TestData.class)
    public void anAustralianComingToUKForTourism(String nationality, String reason) {
        startPage.clickOnCookies();
        startPage.clickStartNow();
        selectNationalityPage.selectNationality(nationality);
        selectNationalityPage.clickNextStepButton();
        reasonForTravelPage.selectReasonForVisit(reason);
        reasonForTravelPage.clickNextStepButton();
        if (getTextFromElement(By.xpath("//div[@class='govuk-!-margin-bottom-6']/h2")).contains(reason)) {
            Assert.assertTrue(true, "passed");
        }
    }
/*
2.aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths().
	Click on start button
	Select a Nationality 'Chile'
	Click on Continue button
	Select reason 'Work, academic visit or business'
	Click on Continue button
	Select intended to stay for 'longer than 6 months'
	Click on Continue button
	Select have planning to work for 'Health and care professional'
	Click on Continue button
	verify result 'You need a visa to work in health and care'	*/

    @Test(groups = {"smoke", "regression"}, dataProvider = "Chile", dataProviderClass = TestData.class)
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths(String nationality, String
            reason, String job) throws InterruptedException {
        startPage.clickOnCookies();
        startPage.clickStartNow();
        selectNationalityPage.selectNationality(nationality);
        selectNationalityPage.clickNextStepButton();
        Thread.sleep(2000);
        reasonForTravelPage.selectReasonForVisit(reason);
        reasonForTravelPage.clickNextStepButton();
        durationOfStayPage.selectLengthOfStay("more");
        durationOfStayPage.clickNextStepButton();
        workTypePage.selectJobType(job);
        workTypePage.clickNextStepButton();
         if (getTextFromElement(By.xpath("//div[@class='govuk-!-margin-bottom-6']/h2")).contains(reason)) {
               Assert.assertTrue(true, "passed");
          }
    }


    /*
    3.aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card()
        Click on start button
        Select a Nationality 'Colombia'
        Click on Continue button
        Select reason 'Join partner or family for a long stay'
        Click on Continue button
        Select state My partner of family member have uk immigration status 'yes'
        Click on Continue button
        verify result 'You’ll need a visa to join your family or partner in the UK'
     */
    @Test(groups = {"regression"}, dataProvider = "Colombia", dataProviderClass = TestData.class)
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card(String nationality, String reason) {
        startPage.clickOnCookies();
        startPage.clickStartNow();
        selectNationalityPage.selectNationality(nationality);
        selectNationalityPage.clickNextStepButton();
        reasonForTravelPage.selectReasonForVisit(reason);
        reasonForTravelPage.clickNextStepButton();
    }


}
