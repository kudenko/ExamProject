package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    protected Logger logger;

    protected WebDriver webDriver;
    protected String expectedURL;

    public ParentPage(WebDriver webDriver, String expectedURL){
        logger = Logger.getLogger(getClass());
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        this.expectedURL = "https://tsn.ua" + expectedURL;
    }

    public void checkCurrentUlr(){
        try{
            Assert.assertEquals("Url is not expected", webDriver.getCurrentUrl(), expectedURL);
        }catch (Exception e){
            logger.error("Cannot get url");
            Assert.fail("Cannot get url");
        }
    }
}
