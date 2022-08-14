package stepdefs;

import io.cucumber.java.en.Given;
import model.reservation.Reservation;

import java.util.Map;

public class ReservationStepDefs {
    Reservation reservation = new Reservation("Dmitrijs", "Tester", "cccccc", "15-02-2018",
            "RIX", "SVO", 12, 3, 0,1);

    @Given("random client with:")
    public void create_client(Map<String, String> params) {

    }
}

