package pages;

import base.PageBase;
import elements.MainMenu;
import elements.SearchField;
import io.qameta.allure.Step;
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

    @FindBy(id = "block_top_menu")
    private WebElement mainMenuBlock;

    @Step("Open 'Contact Us' page")
    public void goToContactUsPage(){
        contactUsMenuItem.click();
    }

    @Step("Go to 'Sign In' page")
    public void goToSignInPage(){
        signInMenuItem.click();
    }

    @Step("Enter {0} in search field")
    public void search(String item){
        SearchField searchField = new SearchField(searchBoxItem);
        searchField.searchItem(item);
    }

    @Step("Go to menu {0} -> submenu {1}")
    public void goToSubMenu(String mainMenuItem, String subMenuItem){
        MainMenu mainMenu = new MainMenu(mainMenuBlock, driver);
        mainMenu.goToSubMenu(mainMenuItem, subMenuItem);
    }

}
