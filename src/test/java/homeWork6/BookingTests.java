package homeWork6;

import homeWork6.pages.BookingPage;
import homeWork6.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import homeWork6.pages.BaseFunct;
import homeWork6.pages.SeatsReservationPage;

public class BookingTests {
    private final String HOME_PAGE_URL = "http://qaguru.lv:8089/tickets/";

    @Test
    public void bookingDetailsCheck() {
        BaseFunct baseFunct = new BaseFunct();
        baseFunct.openUrl(HOME_PAGE_URL);

        HomePage homepage = new HomePage(baseFunct);
        TestValues testValuesActual = homepage.flightPath();

        BookingPage bookingPage = new BookingPage(baseFunct);
        TestValues testValuesExpected = bookingPage.bookingCheck();

        Assertions.assertEquals(
                testValuesActual.getAirportsNameLeft(),
                testValuesExpected.getAirportsNameLeft(),
                "Wrong Left Airport Name!"
        );

        /*Assertions.assertEquals(
                testValuesActual.getAirportsNameRight(),
                testValuesExpected.getAirportsNameRight(),
                "Wrong Right Airport Name!"
        );

        Assertions.assertEquals(
                testValuesExpected.getPrice(),
                testValuesExpected.getPrice(),
                "Wrong price!"
        );*/

        SeatsReservationPage seatsReservationPage = new SeatsReservationPage(baseFunct);
        seatsReservationPage.seatsReservationCheck();

    }
}
