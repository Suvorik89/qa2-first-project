package stepdefs;

import homeWork6.pages.BaseFunct;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.reservation.Reservation;
import org.openqa.selenium.WebElement;
import pageObject.pages.FinalPage;
import pageObject.pages.SeatReservePage;
import pageObject.pages.TicketsHomePage;
import pageObject.pages.UserInfoPage;
import requesters.ReservationsRequester;

import java.util.List;
import java.util.Map;

import static java.lang.Integer.*;
import static org.junit.jupiter.api.Assertions.*;

public class ReservationStepDefs {
    private Reservation reservation;
    private BaseFunct baseFunc = new BaseFunct();
    private TicketsHomePage homePage;
    private UserInfoPage infoPage;
    private SeatReservePage seatReservePage;
    private List<Reservation> response;
    private Reservation reservationFromApi;
    private FinalPage finalPage;

    private final String HOME_PAGE_URL = "http://qaguru.lv:8089/tickets";

    @Given("random client with:")
    public void create_client(Map<String, String> params) {
        reservation = new Reservation("random", "random", params.get("discount"), params.get("flight_date"),
                params.get("airport_from"), params.get("airport_to"), parseInt(params.get("seat_number")),
                2, 2, 2);
    }

    @Given("home page ie opened")
    public void open_home_page() {
        baseFunc.openUrl(HOME_PAGE_URL);
        homePage = new TicketsHomePage(baseFunc);
    }

    @Given("we are selecting airports")
    public void select_airports() {
        homePage.selectAirports(reservation);
        homePage.pressGoBtn();
        infoPage = new UserInfoPage(baseFunc);
    }

    @Then("selected airports appears on client info page")
    public void check_airports() {
        List<WebElement> airports = infoPage.getSelectedAirport();
        assertEquals(reservation.getDepartureAirport(), airports.get(0).getText(), "Incorrect departure airport");
        assertEquals(reservation.getArrivalAirport(), airports.get(1).getText(), "Incorrect arrival airport");
    }

    @When("we are filling in passenger info form")
    public void fill_passenger_info_form() {
        infoPage.fillInfoForm(reservation);
    }

    @When("we are clicking on Get price link")
    public void click_on_get_price_link() {
        infoPage.pressPriceButton();
    }

    @Then("passenger name appears")
    public void check_passenger_name() {
        assertEquals(reservation.getFirstname(), infoPage.getPassengerName(), "Wrong passenger name!");
    }

    @Then("price is: {int} EUR")
    public void price_is_shown(int price) {
        assertEquals(price, infoPage.getPrice(), "Wrong price!");
    }

    @When("we are pressing Book button")
    public void press_book_button() {
        infoPage.clickBookBtn();
        seatReservePage = new SeatReservePage(baseFunc);
    }

    @When("selecting seat number")
    public void select_seat_number() {
        seatReservePage.selectSeat(reservation.getSeatNumber());
    }

    @Then("selected seat number appears")
    public void check_selected_seat_number() {
        assertEquals(reservation.getSeatNumber(), seatReservePage.getSeatNum(), "Incorrect seat number!");
    }

    @When("we are placing the order")
    public void placing_the_order() {
        seatReservePage.clickBookBtn();
        finalPage = new FinalPage(baseFunc);
    }

    @Then("successful booking page appears")
    public void check_booking_page() {
        assertTrue(finalPage.IsReservationSuccessful(), "Reservation isn't succesful!");
    }

    @When("we are requesting all reservations via API")
    public void request_reservations() throws JsonProcessingException {
        ReservationsRequester requester = new ReservationsRequester();
        response = requester.requestReservations();
    }

    @When("we found created reservation")
    public void find_reservation() {
        for (Reservation r : response) {
            if (r.getFirstname().equals(reservation.getFirstname())) {
                reservationFromApi = r;
                break;
            }
        }

        assertNotNull(reservationFromApi, "Can't find created reservation!");
    }

    @Then("all data stored correctly")
    public void check_reservation_data() {
        assertEquals(reservation.getLastName(), reservationFromApi.getLastName(), "Wrong last name!");
        assertEquals(reservation.getDiscount(), reservationFromApi.getDiscount(), "Wrong discount!");
    }
}

