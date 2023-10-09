package testng;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day1 {

    @AfterTest //will be executed after all tests in testng package
    public void afterTest(){
        System.out.println("After Test from Day1 class");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite from Day1 class");
    }
    @Test(dependsOnMethods = {"test10","test20"})//which means test10 and test20 will run first
    public void test1(){
        System.out.println("test1");
    }

    @Test(groups = {"Smoke"})
    public void test2(){
        System.out.println("test2");
    }

    @Test
    public void test10(){
        System.out.println("test10");
    }

    @Test
    public void test20(){
        System.out.println("test20");
        Assert.assertTrue(false);
    }

    @Test(enabled = false)//to skip this test
    public void test30(){
        System.out.println("To skip this test");
    }


    @Test(timeOut = 4000)//will wait 40 seconds before it will throw an error
    public void test40(){
        System.out.println("will wait 40 seconds before it will throw an error");
    }

    @Parameters({"URL", "UserName"})
    @Test
    public void testWithParameters(String urlAddress, String name){
        System.out.println(urlAddress);
        System.out.println(name);
    }
}
