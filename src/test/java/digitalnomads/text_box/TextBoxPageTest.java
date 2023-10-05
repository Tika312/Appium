package digitalnomads.text_box;


import digitalnomads.test_utils.BrowserBaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class TextBoxPageTest extends BrowserBaseTest {

    @BeforeMethod
    public void preSetUp(){
        textBoxPage.openTextBoxPage();
    }


    @Test(dataProvider = "getData")
    public void textBoxPageTest(String name,String email,String currentAddress,String permanentAddress){

        textBoxPage
                .fillUserName(name)
                .fillUserEmail(email)
                .fillCurrentAddress(currentAddress)
                .fillPermanentAddress(permanentAddress)
                .pressEnter()
                .hideKeyBoard();
        scrollDownToElementAction();
        textBoxPage.clickSubmitButton();
    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{{"Tilek","Tony@gmail.com","Monto-Carlo","Bishkek"},
                {"Tony Montana", "Tilec82@mail.ru", "Osh","Dubai"}};
    }




    @Test(dataProvider = "provideDataFromJsonFile")
    public void textBoxPageTest1(HashMap<String,String> inputData){
        textBoxPage
                .fillUserName(inputData.get("name"))
                .fillUserEmail(inputData.get("email"))
                .fillCurrentAddress(inputData.get("currentAddress"))
                .fillPermanentAddress(inputData.get("permanentAddress"))
                .pressEnter()
                .hideKeyBoard();
        scrollDownToElementAction();
        textBoxPage.clickSubmitButton();
    }



    @DataProvider
    public Object[][] provideDataFromJsonFile() throws IOException {
        List<HashMap<String,String>> data =
        getJsonData("C://Users//tilek//IdeaProjects//Appium//src//test//resources//demoqa.json");
        return new Object[][]{{data.get(0)},{data.get(1)}};
    }



}
