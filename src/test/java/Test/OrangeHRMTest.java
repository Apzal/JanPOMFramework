package Test;

import Core.Driver;
import DataProviders.CustomData;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrangeHRMTest {

    private WebDriver driver;
    @Parameters({"browser","url"})
    @BeforeMethod
    public void setUp(String browser,String url){
        driver = Driver.openBrowser(browser);
        driver.navigate().to(url);
        Driver.takeScreenshot(driver);
    }

    @Test(dataProvider="login",dataProviderClass = CustomData.class)
    public void validateLogin(String username,String password){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(username,password);
        HomePage homePage=new HomePage(driver);
        Assert.assertEquals(true,homePage.isUserLoggedIn(),"Could not login ," +
                " Username->"+username+"password->"+password);

        Driver.takeScreenshot(driver);

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeBrowser(driver);
    }

}
