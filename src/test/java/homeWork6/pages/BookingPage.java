package homeWork6.pages;

import homeWork6.TestValues;
import org.openqa.selenium.By;

public class BookingPage {
    private final By NAME_INPUT_FIELD = By.id("name");
    private final By SURNAME_INPUT_FIELD = By.id("surname");
    private final By DISCOUNT_INPUT_FIELD = By.id("discount");
    private final By ADULTS_COUNT_INPUT_FIELD = By.id("adults");
    private final By CHILDREN_COUNT_INPUT_FIELD = By.id("children");
    private final By BUGS_COUNT_INPUT_FIELD = By.id("bugs");
    private final By DATE_FLIGHT_DROP_DOWN = By.xpath(".//select[@class='ffInput']/option");
    private final By GET_PRICE_LINK = By.xpath(".//div[@id='fullForm']/span");
    private final By DESTINATIONS_TITLE = By.xpath(".//span[@class='bTxt']");
    private final By BOOK_BUTTON = By.id("book2");
    private final String DISCOUNT = "Hacker";
    private final String GET_PRICE_BTN = "Get Price";
    private final By GET_PRICE_INT = By.xpath(".//div[@class='responsePrice']");

    private BaseFunct baseFunct;

    public BookingPage(BaseFunct baseFunct) {
        this.baseFunct = baseFunct;
    }

    public TestValues bookingCheck() {
        baseFunct.fillWithRandomText(NAME_INPUT_FIELD);
        baseFunct.fillWithRandomText(SURNAME_INPUT_FIELD);
        baseFunct.type(DISCOUNT_INPUT_FIELD, DISCOUNT);
        baseFunct.fillWithRandomDigit(ADULTS_COUNT_INPUT_FIELD);
        baseFunct.fillWithRandomDigit(CHILDREN_COUNT_INPUT_FIELD);
        baseFunct.fillWithRandomDigit(BUGS_COUNT_INPUT_FIELD);
        baseFunct.dropDownSelectRandom(DATE_FLIGHT_DROP_DOWN);

        baseFunct.clickGetPrice(GET_PRICE_LINK, GET_PRICE_BTN);

        TestValues airportNames = baseFunct.airportNamesCheck(DESTINATIONS_TITLE);
        airportNames.setPrice(baseFunct.getDigitFromString(GET_PRICE_INT));

        baseFunct.click(BOOK_BUTTON);

        return airportNames;
    }
}
