package searchTest;

import org.junit.Test;
import parentTest.ParentTest;

public class SearchTest extends ParentTest {

    @Test

    public void searchTest(){
        searchPage.openSearchPage();
        searchPage.checkCurrentUlr();
        searchPage.enterSearchString("авто");
        searchPage.pressSearchButton();
        searchPage.checkSearcheResults();
    }

}
