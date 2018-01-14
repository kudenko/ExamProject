package searchTest;

import org.junit.Test;
import parentTest.ParentTest;

public class SearchTest extends ParentTest {

    @Test

    public void openSearchPageAndSearch(){
        searchPage.openSearchPage();
        searchPage.enterSearchStringAndSearch("авто");
    }

}
