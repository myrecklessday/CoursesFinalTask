package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainMenu {
    private WebElement selfElement;
    private WebDriver driver;

    public MainMenu(WebElement selfElement, WebDriver driver){
        this.selfElement = selfElement;
        this.driver = driver;
    }

    private String mainMenuItemLocator_xpath = "//ul[contains(@class, 'sf-menu')]//a[text() = 'MainMenuItem']";
    private String subMenuItemLocator_xpath = "//ul[contains(@class, 'submenu-container')]//a[text() = 'SubMenuItem']";


    public void selectMainMenuItem(String mainMenuItem){
        String menuItemLocator = mainMenuItemLocator_xpath.replace("MainMenuItem", mainMenuItem);
        selfElement.findElement(By.xpath(menuItemLocator)).click();
    }

    public void moveToMainMenuItem(String mainMenuItem){
        String menuItemLocator = mainMenuItemLocator_xpath.replace("MainMenuItem", mainMenuItem);
        new Actions(driver).moveToElement(selfElement.findElement(By.xpath(menuItemLocator))).build().perform();
    }

    public void selectSubMenuItem(String subMenuItem){
        String subMenuItemLocator = subMenuItemLocator_xpath.replace("SubMenuItem", subMenuItem);
        selfElement.findElement(By.xpath(subMenuItemLocator)).click();
    }

    public void goToSubMenu(String mainMenuItem, String subMenuItem){
        moveToMainMenuItem(mainMenuItem);
        selectSubMenuItem(subMenuItem);
    }


}
