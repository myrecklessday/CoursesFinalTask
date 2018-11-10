package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchField {
    private WebElement selfElement;

    public SearchField(WebElement selfElement){
        this.selfElement = selfElement;
    }

    private static By searchContainer_locator = By.id("search_query_top");

    private static By searchButton_locator = By.name("submit_search");

    public void searchItem(String itemName){
        selfElement.findElement(searchContainer_locator).sendKeys(itemName);
        selfElement.findElement(searchButton_locator).click();
    }
}
