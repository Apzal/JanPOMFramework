package learningpom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login {

    private WebDriver driver;

    @FindBy(id="txtUsername")
    private WebElement txtUsername;

    By txtUn = By.id("txtUsername");

    @FindBy(id="txtPassword")
    private WebElement txtPassword;

    @FindBy(id="btnLogin")
    private WebElement btnLogin;

    @FindBy(xpath = "//img[contains(@src,'logo.png')]")
    private WebElement imgLogo;

    public Login(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    public void login(String username,String password){
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.submit();




    }



}
