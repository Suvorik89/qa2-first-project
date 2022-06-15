package selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class chekboxAdditionalTask {
    private final String HOME_PAGE_URL = "http://1a.lv";
    private final String CATEGORY_NAME = "Datortehnika, preces birojam";
    private final String SUBCATEGORY_NAME = "Portatīvie datori un aksesuāri";
    private final String SUB_SUBCATEGORY_NAME = "Portatīvie datori";
    private final String CHECKBOX_NAME = "MacBook Air";
    private WebDriver browser;

    final By ACCEPT_COOKIES_BTN = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    private final By LEFT_MENU = By.xpath(".//div[@class = 'site-block welcome-page-carousel']");
    private final By MENU_LINK = By.xpath(".//a[@class = 'submenu-lvl1__link']");
    private final By LEFT_SUBMENU = By.xpath(".//ul[@class = 'menu product-categories-menu']/li/a");
    private final By LEFT_SUB_SUBMENU = By.xpath(".//a[@class = 'list-filterable__label']");
    private final By CHECKBOX_GROUP = By.xpath(".//div[@attr_id = '1']");
    private final By CHECKBOX = By.xpath(".//div[@class = 'catalog-taxons-filter-multiselect__checkbox list-collapsible__item list-filterable__item']");
    private final By CATALOG_ITEM = By.xpath(".//div[contains(@class, 'catalog-taxons-product--grid-view')]");
    private final By MAC_ITEM_NAME = By.xpath(".//a[@class = 'catalog-taxons-product__name']");
    private final By MAC_FILTER_VISIBLE = By.xpath(".//span[@class = 'catalog-taxons-filter-tools__active-filter']");

    @Test
    public void checkboxTest() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get(HOME_PAGE_URL);

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
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

        wait.until(ExpectedConditions.elementToBeClickable(CHECKBOX_GROUP));
        List<WebElement> cbxList = browser.findElement(CHECKBOX_GROUP).findElements(CHECKBOX);
        /*try {
            cbxList.get(0).click();
        } catch (ElementClickInterceptedException e) {
            cbxList.get(0).click();
        }*/

        for (WebElement we : cbxList) {
            if (we.getText().trim().equals(CHECKBOX_NAME)) {
                try {
                    we.click();
                } catch (ElementClickInterceptedException e) {
                    we.click();
                }
                break;
            }
        }

        wait.until(ExpectedConditions.elementToBeClickable(MAC_FILTER_VISIBLE));
        WebElement filterVisible = browser.findElement(MAC_FILTER_VISIBLE);
        if (filterVisible.getText().contains(CHECKBOX_NAME)) {
            List<WebElement> macItems = browser.findElements(CATALOG_ITEM);
            for (int i = 0; i < macItems.size(); i++) {
                Actions action = new Actions(browser);
                try {
                    action.moveToElement(macItems.get(i)).perform();
                    if (macItems.get(i).findElement(MAC_ITEM_NAME).getText().contains(CHECKBOX_NAME)) {
                        System.out.println("It is MacBook Air");
                    }
                } catch (ElementClickInterceptedException e) {
                    action.moveToElement(macItems.get(i)).perform();
                    if (macItems.get(i).findElement(MAC_ITEM_NAME).getText().contains(CHECKBOX_NAME)) {
                        System.out.println("It is MacBook Air");
                    }
                }
            }
        }
    }
}