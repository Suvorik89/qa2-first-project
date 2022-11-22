package pageObject.pages;


import homeWork6.pages.BaseFunct;
import org.openqa.selenium.By;

public class FinalPage {
    private BaseFunct baseFunct;
    private static By SUCCESS_MSG = By.xpath(".//div[@class='finalTxt']");
    private final String finalText = "Thank You for flying with us!";

    public FinalPage(BaseFunct baseFunct) {
        this.baseFunct = baseFunct;
    }

    public boolean IsReservationSuccessful() {
        return baseFunct.findElement(SUCCESS_MSG).getText().equals(finalText);
    }
}
