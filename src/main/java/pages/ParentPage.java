package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    protected Logger logger;

    protected WebDriver webDriver;

    public ParentPage(WebDriver webDriver){
        logger = Logger.getLogger(getClass());
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


}
