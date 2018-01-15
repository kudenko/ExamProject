package pages;

import static libs.ActionsWithOurElements.*;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProfilePage extends ParentPage{

    @FindBy(xpath = ".//h1[contains(text(),'Користувача не авторизовано')]")
    protected WebElement messageNotAutirized;

    @FindBy(xpath = ".//a[@class='u-url u-uid']")
    private List<WebElement> listOfArticleSInProfile;

    public ProfilePage(WebDriver webDriver){
        super(webDriver);
    }

    public void checkAutorization(){
        if(!isElementPresent(messageNotAutirized)){
            logger.info("User logged in profile");
        }else{
            logger.error("User isn't logged in profile");
        }
    }

    public void checkFirstArticle(String addedArticle){
        System.out.println(listOfArticleSInProfile.get(0).getText());
        System.out.println(addedArticle);


        if(listOfArticleSInProfile.get(0).getText().toLowerCase().equals(addedArticle.toLowerCase())){
           logger.info("Article was added successfully");
       }else{
           logger.error("Names of articles are different");
           Assert.fail("Names of articles are different");
       }

    }
}
