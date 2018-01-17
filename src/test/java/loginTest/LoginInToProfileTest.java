package loginTest;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginInToProfileTest extends ParentTest{

    @Test
    public void enterProfile(){
        mainPage.openMainPage();
        mainPage.checkCurrentUlr();
        mainPage.clickLoginIcon();
        mainPage.writeLoginData("ky_se_se@mail.ru", "BGyYH4");
        mainPage.pressLoginButton();
        mainPage.checkLoginSuccess();
    }

}
