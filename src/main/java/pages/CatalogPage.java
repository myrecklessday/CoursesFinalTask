package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogPage extends PageBase {
    public CatalogPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'right-block')]//a[contains(@class, 'product-name')]")
    private List<WebElement> catalogItems;

    public boolean isCatalogItemCorrect(String itemName){
        for (WebElement catalogItem: catalogItems) {
            if (!catalogItem.getAttribute("title").toLowerCase().contains(itemName.toLowerCase())){
                System.out.println(catalogItem.getAttribute("title"));
                return false;
            }
        }
        return true;
    }

}
