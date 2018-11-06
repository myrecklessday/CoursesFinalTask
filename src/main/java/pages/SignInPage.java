package pages;

import base.Email;
import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PageBase {

    private Email emailRand = new Email();

    public SignInPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "email_create")
    private WebElement emailField;

    @FindBy(id = "SubmitCreate")
    private WebElement createAnAccountButton;

//    public void fillInEmail(){
//        emailField.sendKeys(emailRand.getRandEmail());
//    }

    public void createAnAccount(){
        emailField.sendKeys(emailRand.getRandEmail());
        createAnAccountButton.click();
    }
}
