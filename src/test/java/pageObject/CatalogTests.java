package pageObject;

import org.junit.jupiter.api.Test;
import pageObject.pages.BaseFunc;

public class CatalogTests {
    private final String HOME_PAGE_URL = "http://1a.lv";

    @Test
    public void productDetailsCheck() {
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openUrl(HOME_PAGE_URL);
    }
}
