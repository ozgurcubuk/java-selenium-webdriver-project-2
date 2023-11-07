package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;


public class CareersPage {

    WebDriver driver;

    @FindBy(id = "career-our-location")
    WebElement locations;

    @FindBy(className = ".elementor-heading-title.elementor-size-default")
    WebElement lifeAtInsider;

    @FindBy(id = "career-find-our-calling")
    WebElement teams;

    @FindBy(linkText = "See all QA jobs")
    WebElement seeAllQaJobs;

    @FindBy(id = "select2-filter-by-location-container")
    WebElement filterByLocation;

    @FindBy(id = "select2-filter-by-department-container")
    WebElement filterByDepartment;

    @FindBy(id = "jobs-list")
    WebElement jobList;

    @FindBy(id = "career-position-list")
    WebElement careerPositionsList;

    @FindBy(className = ".position-title.font-weight-bold")
    List<WebElement> listedJobTitles;

    @FindBy(className = "position-department")
    List<WebElement> listedJobDepartments;

    @FindBy(className = "position-location")
    List<WebElement> listedJobLocations;

    @FindBy(linkText = "View Role")
    WebElement viewRole;

    public CareersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLocationsPagePresented() {
        return locations.isDisplayed();
    }

    public boolean isTeamsPagePresented() {
        return teams.isDisplayed();
    }

    public void clickToSeeAllQAJobsButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(seeAllQaJobs);
        actions.perform();
        seeAllQaJobs.click();
    }

    public void selectLocationAndDepartmentOptions(String location, String department) {
        filterByLocation.click();
        Select locationDropdown = new Select(driver.findElement(By.id("filter-by-location")));
        locationDropdown.selectByVisibleText(location);
        filterByDepartment.click();
        Select departmentDropdown = new Select(driver.findElement(By.id("filter-by-department")));
        departmentDropdown.selectByVisibleText(department);
        careerPositionsList.click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    public boolean isJobListPresented() {
        return jobList.isDisplayed();
    }

    public boolean isPositionTitleCorrect() {
        for(WebElement job : listedJobTitles) {
            String positionTitle = job.getText();
            if (!positionTitle.contains("Quality Assurance")) {
                return false;
            } else if (!positionTitle.contains("QA")) {
                return false;
            }
        }
        return true;
    }

    public boolean isListedJobDepartmentCorrect(String department) {
        for(WebElement jobDepartment : listedJobDepartments) {
            String positionDepartment = jobDepartment.getText();
            if(!positionDepartment.contains(department)) {
                return false;
            }
        }
        return true;
    }

    public boolean isListedJobLocationCorrect(String location) {
        for(WebElement jobLocation : listedJobLocations) {
            String positionLocation = jobLocation.getText();
            if(!positionLocation.contains(location)) {
                return false;
            }
        }
        return true;
    }

    public String getUrlOfApplicationDirectedAfterViewRoleButtonClick() {
        Actions action = new Actions(driver);
        action.moveToElement(listedJobDepartments.get(0)).build().perform();
        action.moveToElement(viewRole);
        action.click().build().perform();

        String firstTab = driver.getWindowHandle();

        for(String tab:driver.getWindowHandles()) {
            driver.switchTo().window(tab);
            if(!driver.getWindowHandle().equals(firstTab)) {
                return driver.getCurrentUrl();
            }
        }
        return "ERROR";
    }
}
