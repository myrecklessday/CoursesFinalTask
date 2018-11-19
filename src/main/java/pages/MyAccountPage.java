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

    @FindBy(xpath = "//table[@id ='order-list']//tr[contains(@class, 'first_item')]//a[@class = 'color-myaccount']")
    private WebElement lastOrderReference;

    public void signOut(){
        signOutButton.click();
    }

    public String getLastOrderReference(){
        return lastOrderReference.getText();
    }

}
