package pages;

import libs.ActionsWithOurElements;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    protected Logger logger;

    protected WebDriver webDriver;
    protected String expectedURL;

    public static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    public ParentPage(WebDriver webDriver, String expectedURL){
        logger = Logger.getLogger(getClass());
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        ActionsWithOurElements actionsWithOurElements = new ActionsWithOurElements(webDriver);
        this.expectedURL = configProperties.base_url() + expectedURL;
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
