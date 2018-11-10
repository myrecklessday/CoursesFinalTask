import base.MyAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestClass {

    private WebDriver driver;
    private MainPage mainPage;
    private ContactUsPage contactUsPage;
    private SignInPage signInPage;
    private CreateAnAccountPage createAnAccountPage;
    private MyAccountPage myAccountPage;
    private MyAssert myAssert;
    private SearchResultsPage searchResultsPage;

    @BeforeClass
    public void start2() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
        contactUsPage = new ContactUsPage(driver);
        signInPage = new SignInPage(driver);
        createAnAccountPage = new CreateAnAccountPage(driver);
        myAccountPage = new MyAccountPage(driver);
        myAssert = new MyAssert(driver);
        searchResultsPage = new SearchResultsPage(driver);

    }

    @BeforeMethod
    public void start(){
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterClass
    public void finish(){
        driver.quit();
    }

    /**
     * E-1 Verify that contact us form sends successfully
     */
    @Test(dataProvider = "getSubjectHeading")
    public void sendContactUsFormSuccess(String subject) {
        mainPage.goToContactUsPage();
        contactUsPage.fillContactUsForm(subject, "abcde", "Hello! Got the order, thanks!");

        String message = driver.findElement(By.xpath("//p[contains(@class, 'alert-success')]")).getText();
        myAssert.assertTrue(message.contentEquals("Your message has been successfully sent to our team."), "Displayed message should be successful");

    }

    /**
     * E-2 Verify that error message appears if Message area is empty
     */
    @Test(dataProvider = "getSubjectHeading")
    public void sendContactUsFormWithEmptyMessage(String subject){
        mainPage.goToContactUsPage();
        contactUsPage.fillContactUsForm(subject, "abcde", "");
        String message = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]")).getText();
        myAssert.assertTrue(message.contains("The message cannot be blank."),
                "Displayed message should warn about empty message field");
    }

    /**
     * E-3 Verify the ability to register
     */
    @Test
    public void register(){
        mainPage.goToSignInPage();
        signInPage.createAnAccount();
        createAnAccountPage.fillInCreateAnAccountPage("Mrs","Alexa", "Black","12345",
                "Yellow street, 25", "San Francisco","California","44555",
                "7855450");

        myAssert.assertEquals(driver.getCurrentUrl(),
                "http://automationpractice.com/index.php?controller=my-account","URL should be correct");
        myAssert.assertTrue(driver.getTitle().contains("My account"), "Title should contain 'My account' text");

        myAccountPage.signOut();

        int i = 0;
    }

    /**
     * E-4 Verify the ability to search items
     */
    @Test(dataProvider = "searchItemName")
    public void searchItems(String item){
        mainPage.search(item);
        Assert.assertTrue(searchResultsPage.isFoundItemsTitleCorrect(item),"Search results should contain searched item");
    }


    @DataProvider
    public Object[][] getSubjectHeading() {
        return new Object[][]{
                {"Customer service"},
                {"Webmaster"}
        };
    }

    @DataProvider
    public Object[][] searchItemName() {
        return new Object[][]{
                {"blouse"},
                {"shirt"},
                {"dress"}
        };
    }

}



