package digitalnomads.demoTest;

import digitalnomads.test_utils.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;


public class AppiumBasics extends AndroidBaseTest {

    @Test
    public void wifiSettingsName() throws MalformedURLException {


        //locators --> Xpath,id,accessibilityId,classname,androidUIAutomator
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");

        driver.findElement(By.id("android:id/edit")).sendKeys("Tilek Wifi");
//        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
        String okButton = driver.findElements(AppiumBy.className("android.widget.Button")).get(1).getText();
        Assert.assertEquals(okButton,"Cancel");
        //set Wifi Name

    }
}
