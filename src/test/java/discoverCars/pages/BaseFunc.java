package discoverCars.pages;

import discoverCars.Driver;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class BaseFunc {
    private WebDriver driver;
    private WebDriverWait wait;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
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

    public WebElement findElementWithWaitVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> findElements(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElements(locator);
    }

    public void type(By locator, String text) {
        WebElement we = findElement(locator);
        we.clear();
        we.sendKeys(text);
    }

    public void switchingTab(int tabNum){
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(tabNum));
        /*String originalWindow = driver.getWindowHandle();
        assert driver.getWindowHandles().size() == 1;
        driver.findElement(By.linkText("new tab")).click();
        wait.until(numberOfWindowsToBe(tabNum));
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().newWindow(WindowType.TAB);
                //driver.switchTo().window(windowHandle);
                break;
            }
        }
        wait.until(titleIs("Selenium documentation"));*/
    }

    public void dropDownSelect(By locator, String findText) {
        Select select = new Select (driver.findElement(locator));
        select.selectByVisibleText(findText);
    }
}