package digitalnomads.demoTest;


import digitalnomads.test_utils.BrowserBaseTest;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest {


    @Test
    public void browserTest(){
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("Tilek");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    @Test
    public void demoqaMobileTest(){
        driver.get("https://demoqa.com/text-box");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("userName")));
        WebElement fullNameInputField = driver.findElement(By.id("userName"));
        String name = "Tony Montana";
        String email = "Tony@gmail.com";
        String currentAddress = "KG";
        String permanentAddress = "Bishkek";
        fullNameInputField.sendKeys(name);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);
        driver.findElement(By.id("permanentAddress")).sendKeys(permanentAddress);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.hideKeyboard();
        scrollDownToElementAction();
        driver.findElement(By.id("submit")).click();

        scrollDownToElementAction();

        String resultName = driver.findElement(By.xpath("//p[@id='name']")).getText();
        String formattedName = formattedString(resultName);
        String resultEmail = driver.findElement(By.xpath("//p[@id='email']")).getText();
        String formattedEmail = formattedString(resultEmail);
        String resultCurrentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']")).getText();
        String formattedCurrentAddress = formattedString(resultCurrentAddress);
        String resultPermanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText();
        String formattedPermanentAddress = formattedString(resultPermanentAddress);
        Assert.assertEquals(formattedName, name);
        Assert.assertEquals(formattedEmail, email);
        Assert.assertEquals(formattedCurrentAddress, currentAddress);
        Assert.assertEquals(formattedPermanentAddress, permanentAddress);
    }
}
