package pageObject.pages;


import homeWork6.pages.BaseFunct;
import org.openqa.selenium.By;

public class FinalPage {
    private BaseFunct baseFunct;
    private static By TEXT = By.xpath(".//div[@class='finalTxt']");

    public FinalPage(BaseFunct baseFunct) {
        this.baseFunct = baseFunct;
    }

    public String getFinalText(){
        String responseText = baseFunct.findElement(TEXT).getText();
        return responseText;
    }
}
