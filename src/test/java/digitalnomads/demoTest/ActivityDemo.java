package digitalnomads.demoTest;

import digitalnomads.test_utils.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActivityDemo extends AndroidBaseTest {


    @Test
    public void adbTest(){
        //adb devices
        //adb shell dumpsys window | find "mCurrentFocus"
        Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
        driver.startActivity(activity);

        driver.findElement(AppiumBy.id("android:id/checkbox")).click();

        DeviceRotation landscape = new DeviceRotation(0,0,90);
        driver.rotate(landscape);

        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");

        driver.findElement(By.id("android:id/edit")).sendKeys("Tilek Wifi");
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
    }
}
