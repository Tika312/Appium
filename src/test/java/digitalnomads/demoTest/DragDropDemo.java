package digitalnomads.demoTest;

import digitalnomads.test_utils.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragDropDemo extends AndroidBaseTest {


    @Test(groups = {"Smoke"})
    public void dragDropTest(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

       WebElement sourcePoint = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

       androidActions.dragDropAction(sourcePoint,833,740);
        String result = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(result, "Dropped!");
    }

    @Test
    public void demoTest(){
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
        driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).click();
        String alertText = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertText,"Lorem ipsum dolor sit aie consectetur adipiscing\n" +
                "Plloaso mako nuto siwuf cakso dodtos anr koop.");
        driver.findElement(AppiumBy.id("android:id/button1")).click();

        driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a long message")).click();
        String something = driver.findElement(AppiumBy.id("android:id/button3")).getText();
        String cancel = driver.findElement(AppiumBy.id("android:id/button2")).getText();
        String ok = driver.findElement(AppiumBy.id("android:id/button1")).getText();
        Assert.assertEquals(something,"Something");
        Assert.assertEquals(cancel,"Cancel");
        Assert.assertEquals(ok,"OK");
        driver.findElement(AppiumBy.id("android:id/button2")).click();

        driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with ultra long message")).click();
        driver.findElement(AppiumBy.id("android:id/button1")).click();

        driver.findElement(AppiumBy.accessibilityId("List dialog")).click();

        String commandOne = driver.findElement(By.xpath("(//android.widget.TextView)[2]")).getText();
        String commandTwo = driver.findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
        String commandThree = driver.findElement(By.xpath("(//android.widget.TextView)[4]")).getText();
        String commandFour = driver.findElement(By.xpath("(//android.widget.TextView)[5]")).getText();
        Assert.assertEquals(commandOne,"Command one");
        Assert.assertEquals(commandTwo, "Command two");
        Assert.assertEquals(commandThree, "Command three");
        Assert.assertEquals(commandFour, "Command four");
        driver.findElement(By.xpath("(//android.widget.TextView)[5]")).click();
        String popUpMessage = driver.findElement(AppiumBy.id("android:id/message")).getText();
        Assert.assertEquals(popUpMessage,"You selected: 3 , Command four");
        driver.navigate().back();

        driver.findElement(AppiumBy.accessibilityId("Progress dialog")).click();
        WebElement entryDialog = driver.findElement(AppiumBy.accessibilityId("Text Entry dialog"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(entryDialog)).click();
        driver.findElement(AppiumBy.id("io.appium.android.apis:id/username_edit")).sendKeys("Tony");
        driver.findElement(AppiumBy.id("io.appium.android.apis:id/password_edit")).sendKeys("123456");
        driver.findElement(AppiumBy.id("android:id/button1")).click();

        driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
        driver.findElement(AppiumBy.id("android:id/alertTitle")).isDisplayed();
        driver.findElement(By.xpath("//(android.widget.CheckedTextView)[1]")).click();
        driver.findElement(AppiumBy.id("android:id/button1")).click();

        driver.findElement(AppiumBy.accessibilityId("Repeat alarm")).click();
        driver.findElement(By.xpath("//(android.widget.CheckedTextView)[6]")).click();
        String status = driver.findElement(By.xpath("//(android.widget.CheckedTextView)[6]")).getAttribute("checked");
        Assert.assertEquals(status, "true");
        driver.findElement(AppiumBy.id("android:id/button1")).click();

        driver.findElement(AppiumBy.accessibilityId("Text Entry dialog")).click();
        driver.findElement(AppiumBy.id("io.appium.android.apis:id/username_edit")).sendKeys("Tony");
        driver.findElement(AppiumBy.id("io.appium.android.apis:id/password_edit")).sendKeys("123456");
        driver.findElement(AppiumBy.id("android:id/button1")).click();

        driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with traditional theme")).click();
        driver.findElement(AppiumBy.id("android:id/icon")).isDisplayed();
        driver.findElement(AppiumBy.id("android:id/button1")).click();

        driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with Holo Light theme")).click();
        driver.findElement(AppiumBy.id("android:id/button2")).click();

    }
}
