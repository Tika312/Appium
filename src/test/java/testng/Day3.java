package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Day3 {

    @Test(groups = {"Smoke"})
    public void test5(){
        System.out.println("test5");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite from Day3 class");
    }

    @Test
    public void test6(){
        System.out.println("test6");
    }
    @Test(priority = 0)
    public void test12(){
        System.out.println("test12");
    }
    @Test(priority = 0)
    public void test13(){
        System.out.println("test13");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method from Day3 class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After class from Day3 class");
    }
}
