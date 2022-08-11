package discoverCars.pages;

import org.openqa.selenium.By;

public class HomePage {
    private final By ACCEPT_COOKIES_BTN = By.id("onetrust-accept-btn-handler");
    private final By PICK_UP_LOCATION_INPUT_FIELD = By.id("pick-up-location");
    private final By TOOL_TIPS_SEARCH_FIELD = By.xpath(".//div[@class = 'location-item airport tt-suggestion tt-selectable']");

    private final By PICK_UP_CALENDAR = By.id("pick-date-ui");
    private final By DROP_OFF_CALENDAR = By.id("drop-date-ui");
    private final By PICK_UP_TIME = By.id("pick-time");
    private final By DROP_OFF_TIME = By.id("drop-time");
    private final By DROP_OFF_OPTIONS = By.xpath(".//select[@id='drop-time']/option");

    private final By DAY_IN_CALENDAR = By.xpath(".//a[@class='ui-state-default']");
    private final By NAME_OF_MONTH_IN_CALENDAR = By.xpath(".//span[@class='ui-datepicker-month']");
    private final By ARROW_TO_NEXT_MONTH_IN_CALENDAR = By.xpath(".//span[@class='ui-icon ui-icon-circle-triangle-e']");

    private final By SEARCH_BUTTON = By.xpath(".//button[@id='location-submit']");

    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void acceptCookies() {
        baseFunc.click(ACCEPT_COOKIES_BTN);
    }

    public void searchFor(String textToFind) {
        baseFunc.type(PICK_UP_LOCATION_INPUT_FIELD, textToFind);
        baseFunc.toolTipClick(TOOL_TIPS_SEARCH_FIELD);
    }

    public void clickGivenDateAndTime(String pickUpDate, String dropOffDate) {
        baseFunc.setDateInCalendar(PICK_UP_CALENDAR,
                pickUpDate,
                NAME_OF_MONTH_IN_CALENDAR,
                DAY_IN_CALENDAR,
                ARROW_TO_NEXT_MONTH_IN_CALENDAR);

        //baseFunc.dropDownRandomSelect(PICK_UP_TIME);

        baseFunc.setDateInCalendar(DROP_OFF_CALENDAR,
                dropOffDate,
                NAME_OF_MONTH_IN_CALENDAR,
                DAY_IN_CALENDAR,
                ARROW_TO_NEXT_MONTH_IN_CALENDAR);

        //baseFunc.dropDownRandomSelect(DROP_OFF_TIME);
    }

    public void clickOnSearchButton() {
        baseFunc.click(SEARCH_BUTTON);
    }
}



