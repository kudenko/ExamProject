package parentTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ArticlePage;
import pages.MainPage;
import pages.ProfilePage;
import pages.SearchPage;
import pages.categories.VideoPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    public WebDriver webDriver;
    protected MainPage mainPage;
    protected SearchPage searchPage;
    protected ArticlePage articlePage;
    protected VideoPage videoPage;
    protected ProfilePage profilePage;

    @Before

    public void setup(){
        File fileFF = new File("./drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage = new MainPage(webDriver);
        searchPage = new SearchPage(webDriver);
        articlePage = new ArticlePage(webDriver);
        videoPage = new VideoPage(webDriver);
        profilePage = new ProfilePage(webDriver);
    }

    @After

    public void tearDown(){
        webDriver.quit();
    }

}



