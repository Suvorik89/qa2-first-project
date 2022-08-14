package stepdefs;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.weaher.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

import java.util.Map;

public class WeatherStepDefs {
    private long cityId;
    private WeatherResponse response;

    @Given("city id: {long}")
    public void set_city_id(long cityId) {
        this.cityId = cityId;
    }

    @When("we are requesting weather data")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(cityId);
    }

    @Then("coords are:")
    public void check_coords(Map<String, Double> params) {
        Assertions.assertEquals(params.get("lon"), response.getCoord().getLon(), "Wrong Lon!");
        Assertions.assertEquals(params.get("lat"), response.getCoord().getLat(), "Wrong Lat!");
    }

    @Then("weather is:")
    public void check_weather(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("id")), response.getWeathers().get(0).getId(), "Wrong Id (list)!");
        Assertions.assertEquals(params.get("main"), response.getWeathers().get(0).getMain(), "Wrong Main!");
        Assertions.assertEquals(params.get("description"), response.getWeathers().get(0).getDescription(), "Wrong Description!");
        Assertions.assertEquals(params.get("icon"), response.getWeathers().get(0).getIcon(), "Wrong Icon!");
    }

    @Then("base is {string}")
    public void check_base(String base) {
        Assertions.assertEquals(base, response.getBase(), "Wrong Base!");
    }

    @Then("main is:")
    public void check_main(Map<String, String> params) {
        Assertions.assertEquals(Double.parseDouble(params.get("temp")), response.getMain().getTemp(), "Wrong Temp!");
        Assertions.assertEquals(Integer.parseInt(params.get("pressure")), response.getMain().getPressure(), "Wrong Pressure!");
        Assertions.assertEquals(Integer.parseInt(params.get("humidity")), response.getMain().getHumidity(), "Wrong Humidity!");
        Assertions.assertEquals(Double.parseDouble(params.get("temp_min")), response.getMain().getTemp_min(),"Wrong Temp_min!");
        Assertions.assertEquals(Double.parseDouble(params.get("temp_max")), response.getMain().getTemp_max(), "Wrong Temp_max!");
    }

    @Then("visibility is {long}")
    public void check_visibility(Long visibility) {
        Assertions.assertEquals(visibility, response.getVisibility(), "Wrong Visibility!");
    }

    @Then("wind is:")
    public void check_wind(Map<String, String> params) {
        Assertions.assertEquals(Double.parseDouble(params.get("speed")), response.getWind().getSpeed(), "Wrong Speed!");
        Assertions.assertEquals(Integer.parseInt(params.get("deg")), response.getWind().getDeg(), "Wrong Deg!");
    }

    @Then("clouds are:")
    public void check_clouds(Map<String, Integer> params) {
        Assertions.assertEquals(params.get("all"), response.getClouds().getAll(), "Wrong All!");
    }

    @Then("dt is {long}")
    public void check_dt(long dt) {
        Assertions.assertEquals(dt, response.getDt(), "Wrong dt!");
    }

    @Then("sys is:")
    public void check_sys(Map<String, String> params) {
        Assertions.assertEquals(Integer.parseInt(params.get("type")), response.getSys().getType(), "Wrong type!");
        Assertions.assertEquals(Long.parseLong(params.get("id")), response.getSys().getId(), "Wrong Id (sys)!");
        Assertions.assertEquals(Double.parseDouble(params.get("message")), response.getSys().getMessage(), "Wrong Message!");
        Assertions.assertEquals(params.get("country"), response.getSys().getCountry(), "Wrong Country!");
        Assertions.assertEquals(Long.parseLong(params.get("sunrise")), response.getSys().getSunrise(), "Wrong Sunrise!");
        Assertions.assertEquals(Long.parseLong(params.get("sunset")), response.getSys().getSunset(), "Wrong Sunset");
    }

    @Then("id is {long}")
    public void check_id(long id) {
        Assertions.assertEquals(id, response.getId(), "Wrong Id!");
    }

    @Then("name is {string}")
    public void check_name(String name) {
        Assertions.assertEquals(name, response.getName(), "Wrong Name!");
    }

    @Then("cod is {int}")
    public void check_cod(int cod) {
        Assertions.assertEquals(cod, response.getCod(), "Wrong Cod!");
    }
}
