package discoverCars.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CarsPage {

    private final By TOTAL_CARS_CARD = By.xpath(".//div[contains(@class, 'car-box')]");
    private final By VIEW_BUTTON = By.xpath(".//a[contains(@class, 'btn-book')]");
    private BaseFunc baseFunc;

    public CarsPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public List<WebElement> carsCountCheck() {
        List<WebElement> carsCards = baseFunc.findElements(TOTAL_CARS_CARD);
        List<WebElement> viewButtons = baseFunc.findElements(VIEW_BUTTON);
        baseFunc.click(viewButtons.get(0));
        return carsCards;
    }
}
