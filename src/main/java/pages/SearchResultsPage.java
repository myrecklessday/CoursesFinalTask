package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends PageBase {
    public SearchResultsPage(WebDriver driver){
        super(driver);
    }

    @FindAll({@FindBy(xpath = "//div[contains(@class, 'right-block')]//a[contains(@class, 'product-name')]")})
    private List <WebElement> foundItemsTitle;

    @FindAll({@FindBy(xpath = "//a[contains(@title, 'Add to cart')]")})
    private List <WebElement> addToCartButtons;

    @FindBy(className = "clearfix")
    private WebElement itemAddedBanner;

    @FindBy(xpath = "//a[contains(@title, 'Proceed to checkout')]")
    private WebElement proceedToCheckoutButton;

    public boolean isFoundItemsTitleCorrect(String searchItem){
        for (WebElement foundItem: foundItemsTitle) {
            if (!foundItem.getAttribute("title").toLowerCase().contains(searchItem.toLowerCase())) {
                System.out.println("Search result that don't contain 'item': "
                        .replace("item", searchItem) + foundItem.getAttribute("title"));
                return false;
            }
        }
        return true;
    }

    public void addToCartFirstFoundItem(){
        if (addToCartButtons.size() > 0){
            WebElement firstFoundAddToCartButton = addToCartButtons.get(0);
            firstFoundAddToCartButton.click();
        }
        else {
            System.out.println("No items to add to cart!");
        }
    }

    public String getFirstItemTitle(){
        if (foundItemsTitle.size() > 0){
            return foundItemsTitle.get(0).getText();
        }
        else {
            System.out.println("No items to get title from");
        }
        return "";
    }

    public void goToCart(){
        WebElement checkoutButtonWaiter = waitForElementVisible(proceedToCheckoutButton);
        checkoutButtonWaiter.click();
    }

}
