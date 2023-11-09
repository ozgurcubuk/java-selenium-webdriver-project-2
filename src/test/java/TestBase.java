import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;

    protected String info = "[\u001B[34mINFO\u001B[0m] ";

    public TestBase(String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            this.driver = new ChromeDriver();
            System.out.println(info+"chrome driver has been initiated as per user preferences with desired options for local");
        } else if (browser.equalsIgnoreCase("Firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--remote-allow-origins=*");
            System.out.println(info+"firefox driver has been initiated as per user preferences");
            this.driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        System.out.println(info+"all cookies of the browser has been deleted for clearer initial state");
    }

}
