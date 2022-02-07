package Base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait =new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    protected WebElement getElement(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    protected void setText(WebElement element,String text){
        getElement(element).sendKeys(text);
    }


    protected void click(WebElement element){
        getElement(element).click();
    }

    protected void submit(WebElement element){
        getElement(element).submit();
    }

    protected boolean isDisplayed(WebElement element){
        try{
            return getElement(element).isDisplayed();
        }
        catch (NoSuchElementException e){
            System.out.println(e.getMessage());
            return false;
        }
    }



}
