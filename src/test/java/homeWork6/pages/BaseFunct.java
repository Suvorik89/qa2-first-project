package homeWork6.pages;

import homeWork6.TestValues;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BaseFunct {
    private WebDriver driver;
    private WebDriverWait wait;

    public BaseFunct() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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

    public int randomNumber(List <WebElement> options) {
        Random rand = new Random();
        return rand.nextInt(options.size());
    }

    public String dropDownSelectRandom(By locator) {
        List<WebElement> options = driver.findElements(locator);
        int list = randomNumber(options);
        String drpDwn = options.get(list).getText();
        options.get(list).click();
        return drpDwn;
    }

    public void fillWithRandomText(By locator) {
        WebElement we = findElement(locator);
        we.clear();
        String randomName = RandomStringUtils.randomAlphabetic(3, 15).toLowerCase();
        we.sendKeys(randomName);
    }

    public void fillWithRandomDigit(By locator) {
        WebElement we = findElement(locator);
        we.clear();
        String randomCount = RandomStringUtils.randomNumeric(1);
        we.sendKeys(randomCount);
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void type(By locator, String text) {
        WebElement we = findElement(locator);
        we.clear();
        we.sendKeys(text);
    }

    public void clickGetPrice(By locator, String text) {
        List<WebElement> elementNames = driver.findElements(locator);
        for (WebElement we : elementNames) {
            if (we.getText().equals(text)) {
                we.click();
                break;
            }
        }
    }

    public TestValues airportNamesCheck(By locator){
        List<WebElement> elementNames = driver.findElements(locator);
        TestValues airportsNames = new TestValues();
        airportsNames.setAirportsNameLeft(elementNames.get(0).getText());
        airportsNames.setAirportsNameRight(elementNames.get(1).getText());
        return airportsNames;
    }

    public int getDigitFromString(By locator) {
        WebElement we = findElement(locator);
        String numberOnly = we.getText().replaceAll("[^0-9]", "");
        return Integer.parseInt(numberOnly);
    }

    public TestValues seatReservation(By locator) {
        List<WebElement> seatsNumbers = driver.findElements(locator);
        TestValues seatNum = new TestValues();
        int randomItem = randomNumber(seatsNumbers);
        seatNum.setSeatNumber(randomItem);
        seatsNumbers.get(randomItem).click();
        return seatNum;
    }
}

