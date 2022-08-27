package pageObject.pages;

import homeWork6.pages.BaseFunct;
import model.reservation.Reservation;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserInfoPage {
    private final By NAME = By.id("name");
    private final By SURNAME = By.id("surname");
    private final By DISCOUNT = By.id("discount");
    private final By ADULTS = By.id("adults");
    private final By CHILDREN = By.id("children");
    private final By BAGS = By.id("bugs");
    private final By FLIGHT = By.id("flight");
    private final By GET_PRICE_LINK = By.xpath(".//div[@id='fullForm']/span");
    private final String GET_PRICE_BTN = "Get Price";
    private final By BOOK_BUTTON = By.id("book2");

    private final By AIRPORTS = By.xpath(".//span[@class = 'bTxt']");
    private final By GET_PRICE_RESPONSE = By.id("response");
    private final By GET_PRICE_INT = By.xpath(".//div[@class='responsePrice']");

    private BaseFunct baseFunct;

    public UserInfoPage(BaseFunct baseFunct) {
        this.baseFunct = baseFunct;
    }

    public List<WebElement> getSelectedAirport(){
        return baseFunct.findElements(AIRPORTS);
    }

    public void fillInfoForm(Reservation reservation) {
        baseFunct.type(NAME, reservation.getFirstname());
        baseFunct.type(SURNAME, reservation.getLastName());
        baseFunct.type(DISCOUNT, reservation.getDiscount());
        baseFunct.type(ADULTS, reservation.getAdultsCount());
        baseFunct.type(CHILDREN, reservation.getChildCount());
        baseFunct.type(BAGS, reservation.getBagsCount());
        baseFunct.select(FLIGHT, reservation.getFlightDate());
    }

    public void pressPriceButton() {
        baseFunct.clickGetPrice(GET_PRICE_LINK, GET_PRICE_BTN);
    }

    public String getPassengerName() {
        String responseText = baseFunct.findElement(GET_PRICE_RESPONSE).getText();
        return StringUtils.substringBetween(responseText, "Mr/Ms ", "!");
    }

    public int getPrice(){
        String responseText = baseFunct.findElement(GET_PRICE_RESPONSE).getText();
        return Integer.parseInt(StringUtils.substringBetween(responseText, "to for ", " EUR"));
    }

    public void clickBookBtn(){
        baseFunct.click(BOOK_BUTTON);
    }

}
