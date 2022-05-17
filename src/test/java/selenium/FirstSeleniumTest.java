package selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstSeleniumTest {
    @Test
    public void openWebpage() {
        System.setProperty("webdriver.gecko.driver","C://geckodriver.exe");
        WebDriver browser = new FirefoxDriver();
        browser.manage().window().maximize();
        browser.get("http://qaguru.lv");

    }
}
