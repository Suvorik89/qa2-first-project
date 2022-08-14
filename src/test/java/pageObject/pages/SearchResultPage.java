package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage {
    private final By PRODUCT_TYPE = By.xpath(".//span[@class = 'single-title']");
    private BaseFunc baseFunc;

    public SearchResultPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void searchForList(String textToFind) {
        for (WebElement we : baseFunc.findElements(PRODUCT_TYPE)) {
            if (we.getText().equals(textToFind)) {
                baseFunc.click(we);
                break;
            }
        }
    }
}
