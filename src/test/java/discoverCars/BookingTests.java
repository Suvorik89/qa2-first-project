package discoverCars;

import discoverCars.pages.BaseFunc;
import discoverCars.pages.ReservationPage;
import discoverCars.pages.HomePage;
import discoverCars.pages.CarsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.util.List;

public class BookingTests {
    private final String HOME_PAGE_URL = "http://www.discovercars.com/";
    private final LocalDate PICK_UP_DATE = LocalDate.parse("2022-09-19");
    private final LocalDate DROP_OFF_DATE = LocalDate.parse("2022-10-31");
    private final String LOCATION_NAME = "Lisbon Airport (LIS)";

    private final Logger LOGGER = LogManager.getLogger(BookingTests.class);

    @Test
    public void bookingDetailsCheck() {
        Driver driver = new Driver("Mr.", "test", "test", "random",
                "random", "random", LocalDate.now());

        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openUrl(HOME_PAGE_URL);

        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();
        homePage.searchFor(LOCATION_NAME);
        homePage.clickGivenDate(PICK_UP_DATE, DROP_OFF_DATE);
        homePage.clickOnSearchButton();

        CarsPage searchPage = new CarsPage(baseFunc);
        List<WebElement> carsCards = searchPage.carsCountCheck();
        Assertions.assertFalse(carsCards.isEmpty(), "Is empty");
        LOGGER.info("Found " + (carsCards.size() - 1) + " cars");

        baseFunc.switchingTab(1);
        ReservationPage driverPage = new ReservationPage(baseFunc);
        driverPage.driverFormFilling(driver);
    }
}
