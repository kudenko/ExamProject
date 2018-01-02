package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ParentPage {
    protected Logger logger;

    WebDriver webDriver;

    public ParentPage(WebDriver webDriver){
        logger = Logger.getLogger(getClass());
        this.webDriver = webDriver;
    }


}
