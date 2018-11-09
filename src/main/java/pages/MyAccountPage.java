package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

    public MyAccountPage(WebDriver driver){
        super(driver);
    }

    @FindBy(className = "logout")
    private WebElement signOutButton;

    public void signOut(){
        signOutButton.click();
    }

}
