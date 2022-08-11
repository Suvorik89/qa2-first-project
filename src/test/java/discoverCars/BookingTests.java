package discoverCars;

import discoverCars.pages.BaseFunc;
import discoverCars.pages.HomePage;
import org.junit.jupiter.api.Test;

public class BookingTests {
    private final String HOME_PAGE_URL = "http://www.discovercars.com/";
    private final String PICK_UP_DATE = "2022-09-30";
    private final String DROP_OFF_DATE = "2022-11-15";
    private final String LOCATION_NAME = "Lisbon Airport (LIS)";

    @Test
    public void bookingDetailsCheck() {
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openUrl(HOME_PAGE_URL);

        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();
        homePage.searchFor(LOCATION_NAME);
        homePage.clickGivenDateAndTime(PICK_UP_DATE,DROP_OFF_DATE);
        homePage.clickOnSearchButton();
    }
}
