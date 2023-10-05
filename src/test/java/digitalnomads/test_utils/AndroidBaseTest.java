package digitalnomads.test_utils;

import com.google.common.collect.ImmutableMap;
import digitalnomads.app_pages.Preference;
import digitalnomads.utils.AndroidActions;
import digitalnomads.utils.AppiumUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Properties;

public class AndroidBaseTest extends AppiumUtils {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    public Preference preference;
    public AndroidActions androidActions;

    //AndroidDriver object or IOSDriver object
    //Apium code -> Appium Server -> Mobile
    //AppiumDriverLocalService to start automatically

    @BeforeClass(alwaysRun = true)
    public void configureAppium() throws IOException {
        String ipAddress = System.getProperty("ipAddress") !=null ? System.getProperty("ipAddress") : getPropertyOf("ipAddress");
        int port = Integer.parseInt(getPropertyOf("port"));
        service = startAppiumServer(ipAddress,port);

        UiAutomator2Options options = new UiAutomator2Options();
        String androidDeviceName=getPropertyOf("AndroidDeviceName");
            options.setDeviceName(androidDeviceName);
            options.setChromedriverExecutable("C://Users//tilek//OneDrive//Documents//chromedriver_win32");
        options.setApp("C://Users//tilek//IdeaProjects//Appium//src//test//resources//ApiDemos-debug.apk");

        driver = new AndroidDriver(service.getUrl(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        preference = new Preference(driver);
        androidActions = new AndroidActions(driver);
    }


    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
        service.stop();
    }



}
