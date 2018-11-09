package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
    protected WebDriver driver;
    protected WebDriverWait waiter;

    public PageBase(WebDriver driver){
//        this.driver = driver;
//        waiter = new WebDriverWait(driver, 10000);
        PageFactory.initElements(driver, this);
    }

    public WebElement searchElement(By by){
        return driver.findElement(by);
    }

//    public void explicitWait(WebElement webElement){
//        waiter.until(ExpectedConditions.visibilityOf(webElement));
//    }

}
