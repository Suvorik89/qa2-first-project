package pageObject;

import org.junit.jupiter.api.Test;
import pageObject.pages.BaseFunc;
import pageObject.pages.HomePage;
import pageObject.pages.SearchResultPage;

public class CatalogTests {
    private final String HOME_PAGE_URL = "http://1a.lv";
    private final String PRODUCT_TO_FIND = "Apple";
    private final String CATEGORY_NAME = "Apple AirPods";

    @Test
    public void productDetailsCheck() {
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openUrl(HOME_PAGE_URL);

        HomePage homepage = new HomePage(baseFunc);
        homepage.acceptCookies();
        homepage.searchFor(PRODUCT_TO_FIND);

        SearchResultPage searchResultPage = new SearchResultPage(baseFunc);
        searchResultPage.searchForList(CATEGORY_NAME);

    }
}
