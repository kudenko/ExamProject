package mainPageTest;

import org.junit.Test;
import parentTest.ParentTest;

public class MainPageTest extends ParentTest{

    @Test

    public void openMainPage(){
        mainPage.openMainPage();
        mainPage.isTsnLogoPresent();
    }
}
