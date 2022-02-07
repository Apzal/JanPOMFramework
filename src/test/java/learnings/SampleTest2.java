package learnings;

import org.testng.Assert;
import org.testng.annotations.*;

public class SampleTest2 {

    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest-runs first");
    }


    @AfterTest
    public void AfterTest(){
        System.out.println("AfterTest-learnings.SampleTest2");
    }


    @BeforeClass
    public void BeforeClass(){
        System.out.println("BeforeClass-learnings.SampleTest2");
    }

    @AfterClass
    public void AfterClass(){
        System.out.println("AfterClass-learnings.SampleTest2");
    }


    @Test(priority = 1)
    public void login(){
        System.out.println("login");
        int a = 20;
        int b= 40;
        int sum = a+b;
        Assert.assertEquals(sum,60,a+"+"+b+" not equals "+sum);
        System.out.println("Login passed");
    }

    @Test(priority = 2,dependsOnMethods = "login")
    public void doTransaction(){
        System.out.println("doTransaction");
        Assert.assertTrue(true);
    }

    @Test(priority = 3, dependsOnMethods = {"login","doTransaction"})
    public void logout(){
        System.out.println("logout");
    }

    @Test(enabled = true)
    public void test(){
        System.out.println("test executing");
    }
}
