package pages.categories;

import static libs.ActionsWithOurElements.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

import java.util.List;

public class VideoPage extends ParentPage{

    @FindBy(xpath = ".//*[@class='embed-responsive-item']")
    protected WebElement videoInTopOfVideoPage;

    @FindBy (tagName = "iframe")
    protected List<WebElement> playerFrame;

    public VideoPage(WebDriver webDriver){
        super(webDriver, "/video/video-novini");
    }

    public void openVideoCategoryTest(){
        try{
            webDriver.get("https://tsn.ua/video/video-novini");
            logger.info("TSN category video page was opened");
        }catch (Exception e){
            logger.error("Cannot open URL video catrgory");
            Assert.fail("Cannot open URL video catrgory");
        }
    }

    public void checkPresentVideoSrcInMainBlock(){

        if(isElementPresent(videoInTopOfVideoPage) && videoInTopOfVideoPage.getAttribute("src").length() >= 41){
            logger.info("Video is on the page");
        }else{
            logger.info("Video is absent");
            Assert.fail("Video is absent");
        }
    }
}