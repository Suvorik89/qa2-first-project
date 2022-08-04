package homeWork6.pages;

import homeWork6.TestValues;
import org.openqa.selenium.By;

public class HomePage {
    private final By LEFT_DROPDOWN = By.xpath(".//select[@class='inputItem']/option");
    private final By RIGHT_DROPDOWN = By.xpath(".//select[@class='inputItem second']/option");
    private final By GO_BTN = By.xpath(".//span[@class='gogogo']");
    private BaseFunct baseFunct;

    public HomePage(BaseFunct baseFunct) {
        this.baseFunct = baseFunct;
    }

    public TestValues flightPath() {
        TestValues airportNamesActual = new TestValues();
        airportNamesActual.setAirportsNameLeft((baseFunct.dropDownSelectRandom(LEFT_DROPDOWN)));
        airportNamesActual.setAirportsNameRight(baseFunct.dropDownSelectRandom(RIGHT_DROPDOWN));
        baseFunct.click(GO_BTN);
        return airportNamesActual;
    }
}
