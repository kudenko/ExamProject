package loginTest;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginTest extends ParentTest{

    @Test
    public void enterSite(){
        mainPage.enterPage("ky_se_se@mail.ru", "BGyYH4");

    }

}
