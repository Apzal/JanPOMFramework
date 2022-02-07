package learnings;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class ListenersTest {

    @Test(priority = 1)
    public void login(){
        System.out.println("Login");
        Assert.assertTrue(true);
        System.out.println("Login passed");
    }

    @Test(priority = 2)
    public void addProduct(){
        System.out.println("addProduct");
        Assert.fail("Failing add Product");
        System.out.println("addProduct failed");
    }

    @Test(priority = 3,dependsOnMethods = "addProduct")
    public void logout(){
        System.out.println("logout");
    }
}
