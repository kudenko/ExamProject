package profileTest;

import org.junit.Test;
import parentTest.ParentTest;

public class ProfileTest extends ParentTest {
    @Test

    public void addArticleToFavourites(){
        mainPage.enterPage("ky_se_se@mail.ru", "BGyYH4");
        mainPage.goToFirstArticle();
        String article = articlePage.getArticleName();
        articlePage.addArticleToFavourite();
        articlePage.goToProfilePageClickIcon();
        profilePage.checkAutorization();
        profilePage.checkFirstArticle(article);
    }
}
