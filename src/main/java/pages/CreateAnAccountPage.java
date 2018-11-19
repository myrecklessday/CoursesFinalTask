package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class CreateAnAccountPage extends PageBase {

    public CreateAnAccountPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "id_gender1")
    private WebElement genderMrButton;

    @FindBy(id = "id_gender2")
    private WebElement genderMrsButton;

//    @FindAll({@FindBy(className = "radio-inline")})
//    private List<WebElement> genders;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameField;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(name = "firstname")
    private WebElement firstNameAddressField;

    @FindBy(name = "lastname")
    private WebElement lastNameAddressField;

    @FindBy(id = "address1")
    private WebElement addressField;

    @FindBy(id = "city")
    private WebElement cityField;

//    @FindBy(xpath = "//select[contains(@id, 'id_state')]//option[text() = 'StateName']")
//    private String stateCombobox;

//    private String stateCombobox = "//select[contains(@id, 'id_state')]//option[text() = 'StateName']";

    @FindBy(id = "id_state")
    private WebElement stateCombobox;

    @FindBy(id = "postcode")
    private WebElement postalCodeField;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneField;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    public void fillInCreateAnAccountPage(String gender, String firstName, String lastName, String password,
                                          String address, String city, String state, String postalCode,
                                          String mobilePhone){
        if (gender.contentEquals("Mr")){
            genderMrButton.click();
        }
        else if (gender.contentEquals("Mrs")){
            genderMrsButton.click();
        }

        Select dropdownStates = new Select(stateCombobox);
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        passwordField.sendKeys(password);
        String firstNameAddressValue = firstNameAddressField.getAttribute("value");
        String lastNameAddressValue = lastNameAddressField.getAttribute("value");
/*        Assert.assertEquals(firstNameAddressValue, firstName,
                "First name address should be equal to the value in First name field");
        Assert.assertEquals(lastNameAddressValue, lastName,
                "Last name address should be equal to the value in Last name field");
*/
        addressField.sendKeys(address);
        cityField.sendKeys(city);
        dropdownStates.selectByVisibleText(state);
        postalCodeField.sendKeys(postalCode);
        mobilePhoneField.sendKeys(mobilePhone);
        registerButton.click();
    }

}
