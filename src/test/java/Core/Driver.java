package Core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Driver {

    public static WebDriver openBrowser(String browser){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",path+"\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver;

        switch (browser.toLowerCase()){
            case "chrome":
                driver=new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "firefox":
                driver=new FirefoxDriver();
                break;
            default:
                driver=new ChromeDriver();
        }

        return driver;

    }

    public static void closeBrowser(WebDriver driver){
        driver.quit();;
    }

    public static void takeScreenshot(WebDriver driver)  {
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
