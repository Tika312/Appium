package digitalnomads.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;


public class AndroidActions {

    AndroidDriver driver;

    public AndroidActions(AndroidDriver driver) {
        this.driver = driver;
    }

    public void longPressAction(WebElement element){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(),
                "duration",2000));
    }

    public void scrollDownAction(){
        boolean canScrollMore;
        do {

            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0
            ));
        }while (canScrollMore);
    }

    public void scrollDownToElementAction(String element){
        driver.findElement(AppiumBy.androidUIAutomator(" new UiScrollable(new UiSelector())." +
                "scrollIntoView(text(\""+element+"\"));"));
    }

    public void swipeAction(WebElement elementFrom,String direction){
        ((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement) elementFrom).getId(),
                "direction",direction,
                "percent", 0.75
        ));
    }

    public void dragDropAction(WebElement element, int xCordinate, int yCordinate){

        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", xCordinate,
                "endY", yCordinate
        ));
    }

    public void rotateLandScape() {
        DeviceRotation landscape = new DeviceRotation(0, 0, 90);
        driver.rotate(landscape);
    }
}
