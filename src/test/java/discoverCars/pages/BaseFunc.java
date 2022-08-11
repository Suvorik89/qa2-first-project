package discoverCars.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class BaseFunc {
    private WebDriver driver;
    private WebDriverWait wait;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openUrl(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        driver.get(url);
    }

    public void click(By locator) {
        WebElement we = wait.until(ExpectedConditions.elementToBeClickable(locator));
        try {
            we.click();
        } catch (ElementClickInterceptedException e) {
            we.click();
        }
    }

    public void click(WebElement we) {
        wait.until(ExpectedConditions.elementToBeClickable(we));
        try {
            we.click();
        } catch (ElementClickInterceptedException e) {
            we.click();
        }
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void type(By locator, String text) {
        WebElement we = findElement(locator);
        we.clear();
        we.sendKeys(text);
    }

    public void toolTipClick(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement toolTips = driver.findElement(locator);
        click(toolTips);
    }

    public void setDateInCalendar(By calendarLocator, String date, By monthLocator, By dayLocator, By arrowLocator) {
        boolean dateFound = false;
        click(calendarLocator);

        LocalDate dt = LocalDate.parse(date);
        String monthName = String.valueOf(dt.getMonth());
        String dayNum = String.valueOf(dt.getDayOfMonth());

        while (dateFound == false) {
            WebElement month = driver.findElement(monthLocator);
            List<WebElement> columns = driver.findElements(dayLocator);
            String websiteMonthName = month.getText().toUpperCase();

            if (websiteMonthName.equals(monthName)) {
                for (WebElement day : columns) {
                    if (day.getText().equals(dayNum)) {
                        click(day);
                        dateFound = true;
                        break;
                    }
                }
            } else {
                click(arrowLocator);
            }
        }
    }

    public int randomNumber(List<WebElement> options) {
        Random rand = new Random();
        return rand.nextInt(options.size());
    }

    public void dropDownRandomSelect(By locator) {
        WebElement timeDropdown = driver.findElement(locator);
        //Select select = new Select (timeDropdown);
        //select.selectByVisibleText("10:30");
    }
}
