package discoverCars;

import discoverCars.pages.BaseFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.util.List;

public class Helper {
    private final By NAME_OF_MONTH_IN_CALENDAR = By.xpath(".//span[@class='ui-datepicker-month']");
    private final By DAY_IN_CALENDAR = By.xpath(".//a[@class='ui-state-default']");
    private final By ARROW_TO_NEXT_MONTH_IN_CALENDAR = By.xpath(".//span[@class='ui-icon ui-icon-circle-triangle-e']");

    private BaseFunc baseFunc;

    public Helper(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void setDateInCalendar(By calendarLocator, LocalDate date) {
        boolean dateFound = false;
        baseFunc.click(calendarLocator);
        while (!dateFound) {
            WebElement month = baseFunc.findElement(NAME_OF_MONTH_IN_CALENDAR);
            List<WebElement> columns = baseFunc.findElements(DAY_IN_CALENDAR);
            String websiteMonthName = month.getText().toUpperCase();

            if (websiteMonthName.equals(date.getMonth().name())) {
                for (WebElement day : columns) {
                    if (Integer.parseInt(day.getText()) == date.getDayOfMonth()) {
                        baseFunc.click(day);
                        dateFound = true;
                        break;
                    }
                }
            } else {
                baseFunc.click(ARROW_TO_NEXT_MONTH_IN_CALENDAR);
            }
        }
    }
}
