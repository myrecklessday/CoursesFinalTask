package pages;

import base.PageBase;
import elements.SearchField;
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

    @FindBy(id = "searchbox")
    private WebElement searchBoxItem;

    public void goToContactUsPage(){
        contactUsMenuItem.click();
    }

    public void goToSignInPage(){
        signInMenuItem.click();
    }

    public void search(String item){
        SearchField searchField = new SearchField(searchBoxItem);
        searchField.searchItem(item);
    }
}
