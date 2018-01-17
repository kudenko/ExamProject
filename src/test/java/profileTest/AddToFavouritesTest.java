package profileTest;

import libs.BufferClass;
import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddToFavouritesTest extends ParentTest {
    protected BufferClass articleURL;
        @Test

    public void addArticleToFavourites(){
        mainPage.openMainPage();
        mainPage.checkCurrentUlr();
        mainPage.clickLoginIcon();
        mainPage.writeLoginData("ky_se_se@mail.ru", "BGyYH4");
        mainPage.pressLoginButton();
        mainPage.checkLoginSuccess();
        mainPage.goToFirstArticle();

        BufferClass articleTitle = new BufferClass();
        articleURL = new BufferClass();

        articleTitle.setBufferedString(articlePage.getArticleName());
        articleURL.setBufferedString(articlePage.getUrlAddedArticle());

        articlePage.addArticleToFavourite();
        articlePage.clickProfileIcon();
        profilePage.checkAutorisationSuccess();
        profilePage.checkFirstArticle(articleTitle.getBufferedString());
    }

    @After
    public void removeArticleFromFavourites(){
        articlePage.openAddArticlePage(articleURL.getBufferedString());
        articlePage.removeFavouriteArticle();
    }
}
