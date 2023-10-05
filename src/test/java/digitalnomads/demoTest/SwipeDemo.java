package digitalnomads.demoTest;

import digitalnomads.test_utils.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeDemo extends AndroidBaseTest {

    @Test(groups = {"Smoke"})
    public void swipeDemoTest(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();
        String focus = driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable");
        WebElement firstPhoto = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
        Assert.assertEquals(focus, "true");
        //swipe
       androidActions.swipeAction(firstPhoto,"left");

        String afterFocus = driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable");
        Assert.assertEquals(afterFocus,"false");

    }
}
