package digitalnomads.app_pages;

import digitalnomads.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Preference extends AndroidActions {

    AndroidDriver driver;
    public Preference(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(accessibility = "Preference")
    private WebElement preference;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='3. Preference dependencies']")
    private WebElement preferenceDependencies;
    @AndroidFindBy(id = "android:id/checkbox")
    private WebElement checkBox;
    @AndroidFindBy(xpath = "(//android.widget.RelativeLayout)[2]")
    private WebElement relativeLayout;
    @AndroidFindBy(id = "android:id/edit")
    private WebElement inputField;
    @AndroidFindBy(className = "android.widget.Button")
    private List<WebElement> yesOrNo;

    @AndroidFindBy(accessibility = "Views")
    private WebElement viewsButton;
    @AndroidFindBy(accessibility = "WebView")
    private WebElement webViewButton;
    public Preference clickPreference(){
        preference.click();
        return this;
    }
    public Preference clickPreferenceDependencies(){
        preferenceDependencies.click();
        return this;
    }
    public Preference clickCheckBox(){
        checkBox.click();
        return this;
    }
    public Preference clickRelativeLayOut(){
        relativeLayout.click();
        return this;
    }
    public Preference fillUpTheWifiName(String wifiName){
        inputField.sendKeys(wifiName);
        return this;
    }

    public Preference clickOkButton(){
        yesOrNo.get(1).click();
        return this;
    }

    public Preference clickNoButton(){
        yesOrNo.get(0).click();
        return this;
    }

    public Preference clickViewButton(){
        viewsButton.click();
        return this;
    }
    public Preference scrollDownAndClickWebViewButton(){
        scrollDownToElementAction("WebView");
        webViewButton.click();
        return this;
    }
}
