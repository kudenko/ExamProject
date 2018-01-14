package pages;

import static libs.ActionsWithOurElements.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArticlePage extends ParentPage{

    @FindBy(xpath = ".//p[contains(text(), 'Через роки короткий ролик перетворився на популярний мем.')]")
    protected WebElement ukLangText;

    @FindBy(xpath = ".//p[contains(text(), 'Спустя годы короткий ролик превратился в популярный мем.')]")
    protected WebElement ruLangText;

    @FindBy(xpath = ".//abbr[@title='Русский']")
    protected WebElement ruSwitcherIcon;

    @FindBy(xpath = ".//abbr[@title='Українська']")
    protected WebElement uaSwitcherIcon;

    public ArticlePage (WebDriver webDriver){
        super(webDriver);
    }

    public void openArticlePage(){
        try{
            webDriver.get("https://tsn.ua/tsikavinki/poganiy-den-u-merezhi-rozkrili-istoriyu-naypershogo-viralnogo-video-v-istoriyi-1084900.html");
            logger.info("TSN article page was opened");
        }catch (Exception e){
            logger.error("Cannot open URL from article page");
            Assert.fail("Cannot open URL from article page");
        }
    }

    public void switchToUaLang(){
        clickOnElement(uaSwitcherIcon);
    }

    public void switchToRuLang(){
        clickOnElement(ruSwitcherIcon);
    }

    public void switchingLanguagesOnArticlePage(){
        openArticlePage();
        if(!isElementPresent(ukLangText)){
            logger.error("UA language didn't works");
            Assert.fail("UA language didn't works");
        }else {
            logger.info("saw UA text on page");
        }

        switchToRuLang();
        if(!isElementPresent(ruLangText)){
            logger.error("Ru language didn't works");
            Assert.fail("RU language didn't works");
        }else {
            logger.info("saw RU text on page");
        }
        switchToUaLang();
        if(!isElementPresent(ukLangText)){
            logger.error("UA language didn't works");
            Assert.fail("UA language didn't works");
        }else {
            logger.info("saw UA text on page");
        }
    }


}
