import org.junit.Test;
import pages.CareersPage;
import pages.MainPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class JobSearchTest extends TestBase {

    MainPage mainPage;
    CareersPage careersPage;

    public JobSearchTest() {
        super(System.getProperty("browser"));
    }

    @Test
    public void searchQAJobsLocatedInIstanbul() {
        System.out.println(info+"navigation to \"https://useinsider.com/\"");
        driver.get("https://useinsider.com");

        mainPage = new MainPage(driver);
        System.out.println(info+"accepting all cookies and clicking to Company navigation bar element");
        mainPage.acceptAllCookies();
        mainPage.clickToCampanyNavigation();

        System.out.println(info+"clicking to Careers link text under Company navigation bar element");
        mainPage.clickToCareersLinkTextUnderCompanyNavigation();

        System.out.println(info+"checking page title equals to Insider Careers");
        assertEquals("Insider Careers", driver.getTitle());

        careersPage = new CareersPage(driver);
        System.out.println(info+"checking teams and location pages are displayed");
        assertTrue(careersPage.isLocationsPagePresented());
        assertTrue(careersPage.isTeamsPagePresented());

        System.out.println(info+"navigation to \"https://useinsider.com/careers/quality-assurance/\"");
        driver.get("https://useinsider.com/careers/quality-assurance/");

        System.out.println(info+"clicking to See All QA Jobs button");
        careersPage.clickToSeeAllQAJobsButton();

        System.out.println(info+"selecting location as Istanbul, Turkey and Department as Quality Assurrance");
        careersPage.selectLocationAndDepartmentOptions("Istanbul, Turkey","Quality Assurance");

        System.out.println(info+"checking job list presence");
        assertTrue(careersPage.isJobListPresented());

        System.out.println(info+"checking listed position titles");
        assertTrue(careersPage.isPositionTitleCorrect());
        System.out.println(info+"checking listed position department");
        assertTrue(careersPage.isListedJobDepartmentCorrect("Quality Assurance"));
        System.out.println(info+"checking listed position location");
        assertTrue(careersPage.isListedJobLocationCorrect("Istanbul, Turkey"));

        System.out.println(info+"verifying directed page url after View Role button click");
        assertEquals("https://jobs.lever.co/useinsider/78ddbec0-16bf-4eab-b5a6-04facb993ddc", careersPage.getUrlOfApplicationDirectedAfterViewRoleButtonClick());
        driver.quit();
    }
}