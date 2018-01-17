package categoriesTest;

import org.junit.Test;
import parentTest.ParentTest;

public class EnableVideoInMainBockTest extends ParentTest{

    @Test

    public void checkEnablingVideoInVideoCategory(){
        videoPage.openVideoCategoryTest();
        videoPage.checkCurrentUlr();
        videoPage.checkPresentVideoSrcInMainBlock();
    }
}