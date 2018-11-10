package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends PageBase {
    public SearchResultsPage(WebDriver driver){
        super(driver);
    }

    @FindAll({@FindBy(xpath = "//div[contains(@class, 'right-block')]//a[contains(@class, 'product-name')]")})
    private List <WebElement> foundItems;

    public boolean isFoundItemsTitleCorrect(String searchItem){
        for (WebElement foundItem: foundItems) {
            if (foundItem.getAttribute("title").toLowerCase().contains(searchItem)) {
                System.out.println("Search result that contains 'item': "
                        .replace("item", searchItem) + foundItem.getAttribute("title"));
            }
            else {
                System.out.println("Search result that don't contain 'item': "
                        .replace("item", searchItem) + foundItem.getAttribute("title"));
                return false;
            }
        }
        return true;
    }

    public void printFoundTitle (String searchItem) {
        for (WebElement foundItem : foundItems) {
            if (foundItem.getAttribute("title").toLowerCase().contains(searchItem)) {
                System.out.println(foundItem.getAttribute("title"));
            }
            else {
                System.out.println("search results incorrect: " + foundItem.getAttribute("title"));
            }
        }
    }
}
