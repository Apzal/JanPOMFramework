package learningpom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(partialLinkText="Welcome")
    private WebElement txtWelcomeMessage;


    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public boolean isUserLoggedIn(){
        return txtWelcomeMessage.isDisplayed();
    }

}
