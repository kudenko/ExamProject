package categoriesTest;

import org.junit.Test;
import parentTest.ParentTest;

public class VideoCategoryTest extends ParentTest{

    @Test

    public void checkExistingVideo(){
        videoPage.openSearchPage();
        videoPage.presentVideoInMainBlock();
    }
}