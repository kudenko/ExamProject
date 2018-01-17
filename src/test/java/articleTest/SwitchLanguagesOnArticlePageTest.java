package articleTest;

import org.junit.Test;
import parentTest.ParentTest;

public class SwitchLanguagesOnArticlePageTest extends ParentTest{
    @Test

    public void checkSwitchLanguagesOnArticlePage(){
        articlePage.openArticlePage();
        articlePage.checkCurrentUlr();
        articlePage.checkUaTextOnThePage();
        articlePage.switchToRuLang();
        articlePage.checkRuTextOnThePage();
        articlePage.switchToUaLang();
    }
}
