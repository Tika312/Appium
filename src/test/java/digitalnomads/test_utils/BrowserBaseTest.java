package digitalnomads.test_utils;

import digitalnomads.browser_pages.TextBoxPage;
import digitalnomads.utils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class BrowserBaseTest extends AppiumUtils{

    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    public TextBoxPage textBoxPage;

    @BeforeClass(alwaysRun = true)
    public void configureAppium() throws IOException {
        String ippAddress = getPropertyOf("ipAddress");
        int port = Integer.parseInt(getPropertyOf("port"));
        String androidName = getPropertyOf("AndroidDeviceName");
        String browserName = getPropertyOf("browser");
        service = startAppiumServer(ippAddress,port);

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(androidName);
        options.setChromedriverExecutable("C://Users//tilek//OneDrive//Documents//chromedriver_win32//chromedriver.exe");
        options.setCapability("browserName", browserName);

        driver = new AndroidDriver(service.getUrl(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        textBoxPage = new TextBoxPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
        service.stop();
    }


    public void scrollDownToElementAction(){
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)","");
    }

    public static String formattedString(String text){
        String result="";
        for (int i=0; i< text.length(); i++){
            if (text.charAt(i)==':'){
                result = text.substring(i+1);
            }
        }
        return result;
    }
}
