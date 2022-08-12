package discoverCars.pages;

import discoverCars.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;

public class HomePage {
    private final By ACCEPT_COOKIES_BTN = By.id("onetrust-accept-btn-handler");
    private final By PICK_UP_LOCATION_INPUT_FIELD = By.id("pick-up-location");
    private final By TOOL_TIPS_SEARCH_FIELD = By.xpath(".//div[@class = 'location-item airport tt-suggestion tt-selectable']");

    private final By PICK_UP_CALENDAR = By.id("pick-date-ui");
    private final By DROP_OFF_CALENDAR = By.id("drop-date-ui");

    private final By SEARCH_BUTTON = By.xpath(".//button[@id='location-submit']");
    //private final By TOOL_TIP_ITEMS = By.xpath(".//div[contains(@class, 'location-item')]");

    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void acceptCookies() {
        baseFunc.click(ACCEPT_COOKIES_BTN);
    }

    public void searchFor(String textToFind) {
        baseFunc.type(PICK_UP_LOCATION_INPUT_FIELD, textToFind);
        WebElement toolTips = baseFunc.findElementWithWaitVisibility(TOOL_TIPS_SEARCH_FIELD);
        baseFunc.click(toolTips);
    }

    public void clickGivenDate(LocalDate pickUpDate, LocalDate dropOffDate) {
        Helper helper = new Helper(baseFunc);
        helper.setDateInCalendar(PICK_UP_CALENDAR, pickUpDate);
        helper.setDateInCalendar(DROP_OFF_CALENDAR, dropOffDate);
    }

    public void clickOnSearchButton() {
        baseFunc.click(SEARCH_BUTTON);
    }
}



