package testng;

import org.testng.annotations.*;

import java.util.Iterator;

public class Day2 {

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class from Day2 class");
    }

    @Test
    public void test3(){
        System.out.println("test3");
    }

    @Test(groups = {"Smoke"})
    public void test4(){
        System.out.println("test4");
    }

    @BeforeTest // will execute first before all tests via testng.xml file
    public void beforeTest(){
        System.out.println("before test from Day2 class");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("after method from Day2 class");
    }

    @Test(dataProvider = "getData")
    public void testWithDataProvider(String userName, String userPassword){
        System.out.println(userName);
        System.out.println(userPassword);
    }

    @DataProvider
    public Object[][] getData(){
        //1st combination user name, userName password
        //2nd combination user name, userName password
        //3rd combination user name, userName password
        Object[][]data = new Object[3][2];
        //1st combination user name, userName password
        data[0][0] = "Dave";
        data[0][1] = "Bish23123@";
        //2nd combination user name, userName password
        data[1][0] = "John";
        data[1][1] = "fdsfdsf@d435";
        //3rd combination user name, userName password
        data[2][0] = "Bob";
        data[2][1] = "fgfdgBis45432@#";

        return data;

    }

}
