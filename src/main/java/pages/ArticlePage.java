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

    @FindBy(xpath = ".//h1[@class='p-name c-post-title u-uppercase']")
    protected WebElement articleName;

    @FindBy(xpath = ".//*[@class='c-fav js-favorite']")
    protected WebElement favouriteArticleItem;

    @FindBy(xpath = ".//*[@class='c-fav js-favorite is-fav']")
    protected WebElement favouriteArticleActiveItem;

    @FindBy(xpath = ".//a[@href='/profile']")
    protected WebElement profileIcon;

    public ArticlePage (WebDriver webDriver){
        super(webDriver, "/tsikavinki/poganiy-den-u-merezhi-rozkrili-istoriyu-naypershogo-viralnogo-video-v-istoriyi-1084900.html");
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

    public void checkUaTextOnThePage(){
        if(!isElementPresent(ukLangText)){
            logger.error("UA language didn't works");
            Assert.fail("UA language didn't works");
        }else {
            logger.info("saw UA text on page");
        }
    }

    public void checkRuTextOnThePage(){
        if(!isElementPresent(ruLangText)){
            logger.error("RU language didn't works");
            Assert.fail("RU language didn't works");
        }else {
            logger.info("saw RU text on page");
        }
    }

    public String getArticleName(){
        return articleName.getText();
    }

    public void addArticleToFavourite() {
        if (isElementPresent(favouriteArticleActiveItem)) {
            logger.info("Article is already in favourites. Repeat test");
        } else {
            clickOnElement(favouriteArticleItem);
        }
    }

    public void clickProfileIcon(){
        clickOnElement(profileIcon);
    }

    public String getUrlAddedArticle(){
        return webDriver.getCurrentUrl();
    }

    public void openAddArticlePage(String url){
        try{
            webDriver.get(url);
        }catch (Exception e){
            logger.error("Cannot get url of added favourite article");
        }
    }

    public void removeFavouriteArticle(){
        if (isElementPresent(favouriteArticleActiveItem)) {
            clickOnElement(favouriteArticleActiveItem);
            logger.info("Article was removed successfully");
        } else {
            if(isElementPresent(favouriteArticleItem)){
                logger.info("Article wasn't favourite");
            }
        }
    }
}
