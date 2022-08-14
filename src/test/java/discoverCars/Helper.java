package discoverCars;

import discoverCars.pages.BaseFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.util.List;

public class Helper {
    private final By YEAR_IN_CALENDAR = By.xpath(".//div[@class = 'ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-right']//span[@class='ui-datepicker-year']");
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
            WebElement year = baseFunc.findElement(YEAR_IN_CALENDAR);
            WebElement month = baseFunc.findElement(NAME_OF_MONTH_IN_CALENDAR);
            List<WebElement> columns = baseFunc.findElements(DAY_IN_CALENDAR);

            String websiteMonthName = month.getText();
            int websiteYear = Integer.parseInt(year.getText());

            if (websiteMonthName.equalsIgnoreCase(date.getMonth().name()) && websiteYear == date.getYear()) {
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
