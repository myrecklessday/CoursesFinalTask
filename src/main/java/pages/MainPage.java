package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageBase {
//    private WebDriver driver;

    public MainPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "contact-link")
    private WebElement contactUsMenuItem;

    @FindBy(className = "login")
    private WebElement signInMenuItem;

    public void goToContactUsPage(){
        contactUsMenuItem.click();
    }

    public void goToSignInPage(){
        signInMenuItem.click();
    }
}
