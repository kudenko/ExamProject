package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MainPage extends ParentPage{

    public MainPage(WebDriver webDriver){
        super(webDriver);
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
}
