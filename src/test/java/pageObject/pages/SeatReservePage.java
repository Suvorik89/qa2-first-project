package pageObject.pages;

import homeWork6.pages.BaseFunct;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class SeatReservePage {
    private final By SEAT_NUMBERS = By.xpath(".//div[@class='seat']");
    private final By SELECTED_SEAT_NR = By.xpath(".//div[@class='line']");
    private final By BOOK_BUTTON = By.id("book3");

    private BaseFunct baseFunct;

    public SeatReservePage(BaseFunct baseFunct) {
        this.baseFunct = baseFunct;
    }

    public void selectSeat(int seatNum) {
        baseFunct.waitForElementCountAtLeast(SEAT_NUMBERS, 5);

        WebElement seatToChose = null;
        for (WebElement we : baseFunct.findElements(SEAT_NUMBERS)) {
            if (Integer.parseInt(we.getText()) == seatNum) {
                seatToChose = we;
                break;
            }
        }

        Assertions.assertNotNull(seatToChose, "Can't find seat!");
        baseFunct.click(seatToChose);
    }


    public int getSeatNum() {
        String fullText = baseFunct.findElement(SELECTED_SEAT_NR).getText();
        fullText = StringUtils.substringAfter(fullText, ": ");
        return Integer.parseInt(fullText);
    }

    public void clickBookBtn() {
        baseFunct.click(BOOK_BUTTON);
    }
}

