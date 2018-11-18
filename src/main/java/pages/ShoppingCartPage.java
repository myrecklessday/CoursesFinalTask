package pages;

import base.PageBase;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends PageBase {
    public ShoppingCartPage(WebDriver driver){
        super(driver);
    }

    @FindAll({@FindBy(xpath = "//td[contains(@class, 'cart_description')]//a")})
    private List<WebElement> itemsTitleInCart;

    @FindAll({@FindBy(className = "icon-trash")})
    private List<WebElement> deleteIcons;

   // @FindBy(xpath = "//p[contains(@class, 'alert-warning')]")
   @FindBy(css = ".alert-warning")
   private WebElement warningMessage;

   @FindBy(css = ".standard-checkout")
   private WebElement proceedToCheckoutButton;

   @FindBy(id = "email")
   private WebElement emailSignInField;

   @FindBy(id = "passwd")
   private WebElement passwordSignInField;

   @FindBy(id = "SubmitLogin")
   private WebElement signInButton;

   @FindBy(xpath = "//span[text() = 'Proceed to checkout']")
   private WebElement proceedToShippingButton;

   @FindBy()
   private WebElement proceedToPaymentButton;

   @FindBy(id = "cgv")
   private WebElement confirmBox;

   @FindBy(className = "cheque")
   private WebElement payByCheck;

   @FindBy(xpath = "//span[text() = 'I confirm my order']")
   private WebElement confirmOrderButton;


    public String getFirstItemTitleInCart(){
        if (itemsTitleInCart.size() > 0) {
            return itemsTitleInCart.get(0).getText();
        }
        else {
            System.out.println("There are no items in the cart");
        }
        return "";
    }

    public void deleteFirstItem(){
        if (deleteIcons.size() > 0){
            deleteIcons.get(0).click();
        }
        else {
            System.out.println("There are no items in the cart");
        }
    }

    public String getWarningMessage(){
        WebElement warningMessageWaiter;
        try {
            warningMessageWaiter = waitForElementVisible(warningMessage);
        }
        catch (StaleElementReferenceException e){
            warningMessageWaiter = waitForElementVisible(warningMessage);
        }
        return warningMessageWaiter.getText();
    }

    public void proceedToCheckout(){
        proceedToCheckoutButton.click();
    }

    public void signIn(String email, String password){
        emailSignInField.sendKeys(email);
        passwordSignInField.sendKeys(password);
        signInButton.click();
    }

    public void goToShippingStep(){
        proceedToShippingButton.click();
    }

    public void goToPaymentStep(){
        confirmBox.click();
        proceedToCheckoutButton.click();

    }

    public void paymentStep(){
        payByCheck.click();
        confirmOrderButton.click();
    }

}
