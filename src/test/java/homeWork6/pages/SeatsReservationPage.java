package homeWork6.pages;

import homeWork6.TestValues;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class SeatsReservationPage {
    private final By SEAT_NUMBERS = By.xpath(".//div[@class='seat']");
    private final By SEAT_NUMBER_CHECK = By.xpath(".//div[@class='line']");
    private final By BOOK_BUTTON = By.id("book3");
    private BaseFunct baseFunct;

    public SeatsReservationPage(BaseFunct baseFunct) {
        this.baseFunct = baseFunct;
    }

    public void seatsReservationCheck() {
        TestValues seatNum = baseFunct.seatReservation(SEAT_NUMBERS);
        int seatNumber = baseFunct.getDigitFromString(SEAT_NUMBER_CHECK);
        baseFunct.click(BOOK_BUTTON);
        Assertions.assertEquals(
                seatNum.getSeatNumber() + 1,
                seatNumber,
                "Wrong seat number!"
        );
    }
}
