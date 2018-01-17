package pages;

import static libs.ActionsWithOurElements.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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

    @FindBy (xpath = ".//div[@class='c-nav-unit u-show-on-compression u-join-on-compression']")
    private WebElement accountLogo;

    @FindBy(xpath = ".//a[@class='u-url u-uid c-post-img-wrap']")
    private List<WebElement> listOfArticlesHeaders;

    WebDriverWait wait;

    public MainPage(WebDriver webDriver){
        super(webDriver, "/");
        wait = new WebDriverWait(webDriver, 10);
    }

    public boolean isTsnLogoPresent() {
    return isElementPresent(tsnLogo);
    }

    public void clickLoginIcon(){
        clickOnElement(userLoginForClick);
    }

    public void writeLoginData(String login, String pass){
        wait.until(ExpectedConditions.visibilityOf(modalWindowEnter));
        enterTextInToInput(userLogin, login);
        enterTextInToInput(userPass, pass);
    }

    public void pressLoginButton(){
        clickEnter(buttonSubmit);
    }

    public void checkLoginSuccess(){
        if(isElementPresent(textAfterLogin)){
            logger.info("loggin was successful");
        }else{
            logger.error("login was unsuccessful");
            Assert.fail("login was unsuccessful");
        }
    }

    public void openMainPage(){
        try{
            webDriver.get("https://tsn.ua/");
            logger.info("TSN main page was opened");
        }catch (Exception e){
            logger.error("Cannot open URL");
            Assert.fail("Cannot open URL");
        }
    }

//    public void enterAccount(){
//            clickOnElement(accountLogo);
//     }

    public void goToFirstArticle(){
         webDriver.get(listOfArticlesHeaders.get(2).getAttribute("href"));
    }
}
