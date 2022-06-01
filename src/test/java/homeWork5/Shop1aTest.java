package homeWork5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Shop1aTest {
    private final String HOME_PAGE_URL = "http://1a.lv";
    private final By ACCEPT_COOKIES_BTN = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    private final By LEFT_MENU = By.xpath(".//div[@class = 'site-block welcome-page-carousel']");
    private final By MENU_LINK = By.xpath(".//a[@class = 'submenu-lvl1__link']");
    private final By LEFT_SUBMENU = By.xpath(".//ul[@class = 'menu product-categories-menu']/li/a");
    private final By LEFT_SUB_SUBMENU = By.xpath(".//a[@class = 'list-filterable__label']");
    private final By ITEM = By.xpath(".//div[contains(@class, 'catalog-taxons-product--grid-view')]");
    private final By ITEM_NAME = By.xpath(".//a[@class = 'catalog-taxons-product__name']");
    private final By ITEM_PRICE = By.xpath(".//div[@class = 'product-price-details__block']/span[@class = 'price']");

    private final String CATEGORY_NAME = "Auto un moto preces";
    private final String SUBCATEGORY_NAME = "Ekipējums moto braukšanai";
    private final String SUB_SUBCATEGORY_NAME = "Moto aksesuāri";

    @Test
    public void searchItemPrice() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get(HOME_PAGE_URL);

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));

        browser.findElement(ACCEPT_COOKIES_BTN).click();

        List<WebElement> menuItems = browser.findElement(LEFT_MENU).findElements(MENU_LINK);
        for (WebElement we : menuItems) {
            if (we.getText().trim().equals(CATEGORY_NAME)) {
                wait.until(ExpectedConditions.elementToBeClickable(we));
                try {
                    we.click();
                } catch (ElementClickInterceptedException e) {
                    we.click();
                }
                break;
            }
        }

        List<WebElement> subMenuItems = browser.findElements(LEFT_SUBMENU);
        for (WebElement wes : subMenuItems) {
            if (wes.getText().trim().equals(SUBCATEGORY_NAME)) {
                wait.until(ExpectedConditions.elementToBeClickable(wes));
                try {
                    wes.click();
                } catch (ElementClickInterceptedException e) {
                    wes.click();
                }
                break;
            }
        }

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(LEFT_SUB_SUBMENU, 1));

        List<WebElement> subSubMenuItems = browser.findElements(LEFT_SUB_SUBMENU);
        for (WebElement we : subSubMenuItems) {
            if (we.getText().trim().equals(SUB_SUBCATEGORY_NAME)) {
                we.click();
                break;
            }
        }

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(ITEM, 1));
        List<WebElement> items = browser.findElements(ITEM);

        Random rand = new Random();
        int randomItem = rand.nextInt(items.size());

        Actions action = new Actions(browser);

        try {
            action.moveToElement(items.get(randomItem)).perform();
        } catch (MoveTargetOutOfBoundsException e) {
            action.pause(3000).moveToElement(items.get(randomItem)).perform();
        }

        items.get(randomItem).findElement(ITEM_NAME).click();

        WebElement price = browser.findElement(ITEM_PRICE);
        System.out.println("Price: " + price.getText());
    }
}
