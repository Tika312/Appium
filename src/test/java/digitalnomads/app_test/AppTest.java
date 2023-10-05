package digitalnomads.app_test;


import digitalnomads.test_utils.AndroidBaseTest;
import org.testng.annotations.Test;

public class AppTest extends AndroidBaseTest {

    @Test
    public void preferenceTest(){
        preference.clickPreference()
                .clickPreferenceDependencies()
                .clickCheckBox()
                .clickRelativeLayOut()
                .fillUpTheWifiName("Tilek")
                .clickNoButton()
                .rotateLandScape();
    }

    @Test
    public void webViewTest(){
        preference.clickViewButton()
                .scrollDownAndClickWebViewButton();
    }
}
