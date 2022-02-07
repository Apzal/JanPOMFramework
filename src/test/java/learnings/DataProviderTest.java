package learnings;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DataProviderTest {

    WebDriver driver;

  //  @Parameters({"url"})
    @BeforeMethod
    public void setUp(){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",path+"\\src\\main\\resources\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
    }

    @Test(dataProvider = "credentials",dataProviderClass = CustomDataProvider.class )
    public void login(String username,String password){
        driver.findElement(By.id("txtUsername")).sendKeys(username);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).submit();
        boolean isLoggedIn = false;
        try {
            isLoggedIn = driver.findElement(By.linkText("Welcome Paul")).isDisplayed();
        }
        catch (NoSuchElementException e){

        }


        Assert.assertTrue(isLoggedIn,"User cannot login");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }






}
