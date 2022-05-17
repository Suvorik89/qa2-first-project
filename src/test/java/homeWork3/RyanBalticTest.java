package homeWork3;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RyanBalticTest {
    private final String HOME_PAGE_URL = "http://www.qaguru.lv:8089/tickets/step2.php?afrom=CPT&bfrom=BCN";
    private final By NAME_INPUT_FIELD = By.id("name");
    private final By SURNAME_INPUT_FIELD = By.id("surname");
    private final By DISCOUNT_INPUT_FIELD = By.id("discount");
    private final By ADULT_COUNT_INPUT_FIELD = By.id("adults");
    private final By CHILDREN_COUNT_INPUT_FIELD = By.id("children");
    private final By BUGS_COUNT_INPUT_FIELD = By.id("bugs");
    private final By DATE_FLIGHT_DROP_DOWN = By.id("flight");
    private final By GET_PRICE_LINK = By.xpath(".//div[@id='fullForm']/span");

    @Test
    public void inputFieldsCheck() {
        System.setProperty("webdriver.gecko.driver", "C://geckodriver.exe");
        WebDriver browser = new FirefoxDriver();
        browser.get(HOME_PAGE_URL);

        WebElement nameInputField = browser.findElement(NAME_INPUT_FIELD);
        nameInputField.sendKeys("Jekaterina");

        WebElement surnameInputField = browser.findElement(SURNAME_INPUT_FIELD);
        surnameInputField.sendKeys("Suvorova");

        WebElement discountInputField = browser.findElement(DISCOUNT_INPUT_FIELD);
        discountInputField.sendKeys("SALE20");

        WebElement adultCountInputField = browser.findElement(ADULT_COUNT_INPUT_FIELD);
        adultCountInputField.sendKeys("2");

        WebElement childrenCountInputField = browser.findElement(CHILDREN_COUNT_INPUT_FIELD);
        childrenCountInputField.sendKeys("1");

        WebElement bugsCountInputField = browser.findElement(BUGS_COUNT_INPUT_FIELD);
        bugsCountInputField.sendKeys("2");

        Select drpDateFlight = new Select(browser.findElement(DATE_FLIGHT_DROP_DOWN));
        drpDateFlight.selectByVisibleText("15-05-2018");

        List<WebElement> elementNames = browser.findElements(GET_PRICE_LINK);
        for (WebElement we : elementNames) {
            if (we.getText().equals("Get Price")) {
                we.click();
                break;
            }
        }
    }
}
