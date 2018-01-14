package parentTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ArticlePage;
import pages.MainPage;
import pages.SearchPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    public WebDriver webDriver;
    protected MainPage mainPage;
    protected SearchPage searchPage;
    protected ArticlePage articlePage;

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
    }

    @After

    public void tearDown(){
        webDriver.quit();
    }

}



