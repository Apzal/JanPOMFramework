package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage {


    @FindBy(id="txtUsername")
    private WebElement txtUsername;

    @FindBy(id="txtPassword")
    private WebElement txtPassword;

    @FindBy(id="btnLogin")
    private WebElement btnLogin;

    @FindBy(xpath = "//img[contains(@src,'logo.png')]")
    private WebElement imgLogo;

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }


    public void login(String username,String password){
        setText(txtUsername,username);
        setText(txtPassword,password);
        submit(btnLogin);

    }



}