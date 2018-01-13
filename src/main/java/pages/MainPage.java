package pages;

import static libs.ActionsWithOurElements.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends ParentPage{

    @FindBy(xpath = ".//a[@class='c-logo js-logo']")
    private WebElement tsnLogo;

    @FindBy(id = "userLogin")
    private WebElement userLoginForClick;

    @FindBy(name = "email")
    private WebElement userLogin;

    @FindBy(name = "password")
    private WebElement userPass;

    @FindBy(id = "modalLabel")
    private WebElement modalWindowEnter;

    @FindBy(xpath = ".//button[@type='submit' and contains(text(), 'Авторизуватися')]")
    private WebElement buttonSubmit;

    @FindBy(xpath = ".//span[contains (text(), 'Sergey')]")
    private WebElement textAfterLogin;

    WebDriverWait wait;

    public MainPage(WebDriver webDriver){
        super(webDriver);
        wait = new WebDriverWait(webDriver, 10);
    }

    public boolean isTsnLogoPresent() {
    return isElementPresent(tsnLogo);
    }

    public void enterPage(String login, String pass){
        openMainPage();
        clickOnElement(userLoginForClick);
        wait.until(ExpectedConditions.visibilityOf(modalWindowEnter));
        enterTextInToInput(userLogin, login);
        enterTextInToInput(userPass, pass);
        clickEnter(buttonSubmit);
        isElementPresent(textAfterLogin);
    }

//    public void enterLogIntoInput(WebElement userLogn, String login){
//        enterTextInToInput(userLogn, "ky_se_se@mail.ru");
//    }
//
//    public void enterPassIntoInnput(WebElement userPass, String pass){
//        enterTextInToInput(userPass, "BGyYH4");
//    }

        public void openMainPage(){
        try{
            webDriver.get("https://tsn.ua/");
            logger.info("TSN main page was opened");
        }catch (Exception e){
            logger.error("Cannot open URL");
            Assert.fail("Cannot open URL");
        }
    }
}
