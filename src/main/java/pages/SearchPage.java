package pages;

import static libs.ActionsWithOurElements.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends ParentPage{

    @FindBy(xpath = ".//article[@class ='h-entry c-entry']")
    private List<WebElement> allSearchedArticles;

    @FindBy(name = "query")
    private WebElement queryField;

    @FindBy(xpath = ".//button[@type='submit'] ")
    private WebElement searchButton;


    public SearchPage(WebDriver webDriver){
        super(webDriver, "/search");
    }

    public void openSearchPage(){
        try{
            webDriver.get("https://tsn.ua/search");
            logger.info("TSN search page was opened");
        }catch (Exception e){
            logger.error("Cannot open URL");
            Assert.fail("Cannot open URL");
        }
    }

    public void enterSearchString(String search){
        enterTextInToInput(queryField, search);
    }

    public void pressSearchButton(){
        clickEnter(searchButton);
    }

    public void checkSearcheResults(){
        if(countElements(allSearchedArticles) < 10 ){
            logger.error("Search did't find articles");
            Assert.fail("Search did't find articles");
        }else{
            logger.info("Search test found articles");
        }
    }

}
