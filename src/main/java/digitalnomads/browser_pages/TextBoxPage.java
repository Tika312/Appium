package digitalnomads.browser_pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage {

    Actions actions;
    AndroidDriver driver;
    public TextBoxPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @FindBy(id = "userName")
    private WebElement userNameInput;
    @FindBy(id = "userEmail")
    private WebElement userEmailInput;
    @FindBy(id = "currentAddress")
    private WebElement currentAddressInput;
    @FindBy(id = "permanentAddress")
    private WebElement permanentAddressInput;
    @FindBy(id = "submit")
    private WebElement submitButton;


    public TextBoxPage openTextBoxPage(){
        driver.get("https://demoqa.com/text-box");
        return this;
    }
    public TextBoxPage fillUserName(String userName){
        userNameInput.sendKeys(userName);
        return this;
    }

    public TextBoxPage fillUserEmail(String userEmail){
        userEmailInput.sendKeys(userEmail);
        return this;
    }

    public TextBoxPage fillCurrentAddress(String userCurrentAddress){
        currentAddressInput.sendKeys(userCurrentAddress);
        return this;
    }

    public TextBoxPage fillPermanentAddress(String userPermanentAddress){
        permanentAddressInput.sendKeys(userPermanentAddress);
        return this;
    }

    public TextBoxPage pressEnter(){
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        return this;
    }

    public TextBoxPage hideKeyBoard(){
        driver.hideKeyboard();
        return this;
    }

    public TextBoxPage clickSubmitButton(){
        submitButton.click();
        return this;
    }

}
