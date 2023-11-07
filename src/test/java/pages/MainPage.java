package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {

    WebDriver driver;

    @FindBy(id = "navbarDropdownMenuLink")
    List<WebElement> navigationBarElements;

    @FindBy(linkText = "Careers")
    WebElement careers;

    @FindBy(id = "wt-cli-accept-all-btn")
    WebElement acceptAllCookies;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void acceptAllCookies() {
        acceptAllCookies.click();
    }

    public void clickToCampanyNavigation() {
        navigationBarElements.get(4).click();
    }

    public void clickToCareersLinkTextUnderCompanyNavigation() {
        careers.click();
    }
}
