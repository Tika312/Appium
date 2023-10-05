package digitalnomads.demoTest;


import digitalnomads.test_utils.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class ScrollDemo extends AndroidBaseTest {



    @Test
    public void scrollDown(){

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        androidActions.scrollDownToElementAction("WebView");
    }


}
