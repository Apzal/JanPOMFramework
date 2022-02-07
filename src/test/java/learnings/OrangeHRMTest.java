package learnings;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrangeHRMTest {

    static WebDriver driver;
    @Parameters({"url"})
    @BeforeMethod
    public void setUp(String url){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",path+"\\src\\main\\resources\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
        takeScreenshot();
    }


    @Test(dataProvider = "credentials" ,dataProviderClass = CustomDataProvider.class)
    public void login(String username, String password){

      driver.findElement(By.id("txtUsername")).sendKeys(username);
      driver.findElement(By.id("txtPassword")).sendKeys(password);
      driver.findElement(By.id("btnLogin")).submit();
      boolean isLoggedIn = false;

      isLoggedIn = driver.findElement(By.partialLinkText("Welcomes")).isDisplayed();




      Assert.assertTrue(isLoggedIn,"User cannot login");


    }

//    @Test
//    public void validateTitle(){
//
//        Assert.assertEquals(driver.getTitle(),"OrangeHRM", "Title not matching Expected: OrangeHRM, Actual:"+driver.getTitle());
//
//    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public static void takeScreenshot()  {
        File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        SimpleDateFormat dateFormat= new SimpleDateFormat("ddMMyyyy_hhmmss");
        String timestamp = "Screenshot_"+dateFormat.format(new Date());
        try{

            FileUtils.copyFile(ss.getAbsoluteFile(),new File(System.getProperty("user.dir")+"\\src\\main\\screenshots\\"+timestamp+".png"));
        }
        catch (IOException e){
            System.out.println("Cannot Copy file:"+e.getMessage());
        }
    }



   }


