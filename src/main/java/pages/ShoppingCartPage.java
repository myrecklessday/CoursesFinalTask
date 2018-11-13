package pages;

import base.PageBase;
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
        WebElement warningMessageWaiter = waitForElementVisible(warningMessage);
        return warningMessageWaiter.getText();
    }
}
