package pages;

import base.PageBase;
import base.Email;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class ContactUsPage extends PageBase {
//    private WebDriver driver;
    private File file = new File("src/main/resources/fileForContactUsForm.txt");
    private Email emailRand = new Email();

    public ContactUsPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "id_contact")
    private WebElement subjectHeadingField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "id_order")
    private WebElement orderReferenceField;

    @FindBy(id = "message")
    private WebElement messageField;

    @FindBy(id = "fileUpload")
    private WebElement chooseFileButton;

    @FindBy(id = "submitMessage")
    private WebElement sendButton;

    public void fillContactUsForm(String subject, String orderReference, String message){
        subjectHeadingField.sendKeys(subject);
        emailField.sendKeys(emailRand.getRandEmail());
        orderReferenceField.sendKeys(orderReference);
        messageField.sendKeys(message);
        chooseFileButton.sendKeys(file.getAbsolutePath());
        sendButton.click();
    }
}
