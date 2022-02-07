package learnings;

import org.testng.annotations.*;

public class SampleTest3 {

    @BeforeTest()
    public void beforeTest(){
        System.out.println("beforeTest-runs second");
    }

    @BeforeClass
    public void BeforeClass(){
        System.out.println("BeforeClass");
    }

    @BeforeGroups(groups = {"Smoke Test","Sanity Test"})
    public void BeforeGroups(){
        System.out.println("BeforeGroups");
    }

    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("BeforeMethod");
    }

    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("BeforeSuite");
    }

    @AfterClass
    public void AfterClass(){
        System.out.println("AfterClass");
    }

    @AfterGroups(groups = {"Smoke Test","Sanity Test"})
    public void AfterGroups(){
        System.out.println("AfterGroups");
    }


    @AfterTest
    public void AfterTest(){
        System.out.println("AfterTest");
    }

    @AfterMethod
    public void AfterMethod(){
        System.out.println("AfterMethod");
    }

    @AfterSuite
    public void AfterSuite(){
        System.out.println("AfterSuite");
    }

    @Test(groups = "Smoke Test")
    public void test1(){
        System.out.println("test1");
    }

    @Test(groups = "Sanity Test")
    public void test3(){
        System.out.println("test3");

    }

    @Test(groups = "Smoke Test")
    public void test2(){
        System.out.println("test2");
    }


}
