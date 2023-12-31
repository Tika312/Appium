package digitalnomads.demoTest;


import digitalnomads.test_utils.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LongPressTest extends AndroidBaseTest {

    @Test(groups = {"Smoke"})
    public void longPressTestGesture(){

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

        WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        androidActions.longPressAction(element);

        String menuText = driver.findElement(By.id("android:id/title")).getText();
        Assert.assertEquals(menuText,"Sample menu");

    }
}
