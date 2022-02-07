package Pages;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(partialLinkText="Welcome")
    private WebElement txtWelcomeMessage;


    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean isUserLoggedIn(){
        return isDisplayed(txtWelcomeMessage);
    }

}
