package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainMenu {
    private WebElement selfElement;
    private WebDriver driver;
    private WebDriverWait wait;

    public MainMenu(WebElement selfElement, WebDriver driver){
        this.selfElement = selfElement;
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public WebElement waitForElementVisible(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
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
        WebElement subMenuWaiter;
        try {
            subMenuWaiter = waitForElementVisible(selfElement.findElement(By.xpath(subMenuItemLocator)));
        }
        catch (StaleElementReferenceException e){
            subMenuWaiter = waitForElementVisible(selfElement.findElement(By.xpath(subMenuItemLocator)));
        }
        subMenuWaiter.click();
    }

    public void goToSubMenu(String mainMenuItem, String subMenuItem){
        moveToMainMenuItem(mainMenuItem);
        selectSubMenuItem(subMenuItem);
    }


}
