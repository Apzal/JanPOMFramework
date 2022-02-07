package learningpom;

import learnings.CustomDataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import learningpom.pages.HomePage;
import learningpom.pages.Login;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",path+"\\src\\main\\resources\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");

    }

    @Test(dataProvider = "credentials" ,dataProviderClass = CustomDataProvider.class)
    public void validateUserLogin(String username,String password){
        Login login=new Login(driver);
        login.login(username,password);
        HomePage homePage=new HomePage(driver);
        Assert.assertTrue(homePage.isUserLoggedIn(),"User cannot login");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
