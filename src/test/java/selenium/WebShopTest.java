package selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebShopTest {
    private final String HOME_PAGE_URL = "http://1a.lv";
    private final By SEARCH_INPUT_FIELD = By.id("q"); //локатор по ID
    private final By PRODUCT_TYPE = By.xpath(".//span[@class = 'single-title']");


    @Test
    public void searchFieldCheck() {
        System.setProperty("webdriver.gecko.driver","C://geckodriver.exe");
        WebDriver browser = new FirefoxDriver();
        browser.manage().window().maximize();
        browser.get(HOME_PAGE_URL);

        WebElement searchField = browser.findElement(SEARCH_INPUT_FIELD); //находим элемент по локатору
        searchField.sendKeys("Apple");
        searchField.sendKeys(Keys.ENTER);
    }
}
