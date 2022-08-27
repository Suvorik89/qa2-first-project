package pageObject.pages;

import homeWork6.pages.BaseFunct;
import model.reservation.Reservation;
import org.openqa.selenium.By;

public class TicketsHomePage {
    private final By FROM = By.id("afrom");
    private final By TO = By.id("bfrom");
    private final By GO_BTN = By.xpath(".//span[@class='gogogo']");

    private BaseFunct baseFunct;

    public TicketsHomePage(BaseFunct baseFunct) {
        this.baseFunct = baseFunct;
    }

    public void selectAirports(Reservation reservation){
        baseFunct.select(FROM, reservation.getDepartureAirport());
        baseFunct.select(TO, reservation.getArrivalAirport());
    }

    public void pressGoBtn(){
        baseFunct.click(GO_BTN);
    }
}
