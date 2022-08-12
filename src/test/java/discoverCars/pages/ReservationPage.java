package discoverCars.pages;

import discoverCars.Driver;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class ReservationPage {
    private final By TITLE_DROPDOWN = By.id("driverTitle");
    private final By FIRST_NAME_INPUT = By.id("driverName");
    private final By LAST_NAME_INPUT = By.id("driverLastName");
    private final By EMAIL_INPUT = By.id("driverEmail");
    private final By PHONE_COUNTRY_CODE_INPUT = By.id("phoneCountryCode");
    private final By PHONE_INPUT = By.id("driverPhone");
    private final By YEAR_BIRTH_DROPDOWN = By.id("driver_birth_dt_year");
    private final By MONTH_BIRTH_DROPDOWN = By.id("driver_birth_dt_month");
    private final By DAY_BIRTH_DROPDOWN = By.id("driver_birth_dt_day");
    private final By BOOK_NOW_BUTTON = By.id("createReservation");

    private BaseFunc baseFunc;

    public ReservationPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void driverFormFilling(Driver driver){
        baseFunc.dropDownSelect(TITLE_DROPDOWN, driver.getTitle());
        baseFunc.type(FIRST_NAME_INPUT, driver.getFirstName());
        baseFunc.type(LAST_NAME_INPUT, driver.getLastName());
        baseFunc.type(EMAIL_INPUT, driver.getEmail());
        baseFunc.type(PHONE_COUNTRY_CODE_INPUT, driver.getCountyCode());
        baseFunc.type(PHONE_INPUT, driver.getPhoneNumber());

        LocalDate year = driver.getBirthDay().minusYears(35);
        baseFunc.dropDownSelect(YEAR_BIRTH_DROPDOWN, String.valueOf(year.getYear()));
        baseFunc.dropDownSelect(MONTH_BIRTH_DROPDOWN, driver.getBirthDay().getMonth().getDisplayName(TextStyle.SHORT, Locale.US));
        baseFunc.dropDownSelect(DAY_BIRTH_DROPDOWN, String.valueOf(driver.getBirthDay().getDayOfMonth()));

        baseFunc.click(BOOK_NOW_BUTTON);
    }
}