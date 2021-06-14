package ui.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PersonalPage {

    WebDriver driver;

    public PersonalPage(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "borrowerFirstName")
    public WebElement firstNameTextBox;

    @FindBy(name = "borrowerLastName")
    public WebElement lastNameTextBox;

    @FindBy(name = "borrowerStreet")
    public WebElement streetTextBox;

    @FindBy(css = "ul#geosuggest__list--borrowerStreet li")
    public List<WebElement> addressSuggestions;

    @FindBy(name= "borrowerDateOfBirth")
    public WebElement dobTextBox;

    @FindBy(xpath = "//button[@data-auto='continuePersonalInfo']")
    public WebElement continuePersonalInfoButton;

    public void fillPersonalDetails() {
        String firstName = RandomStringUtils.randomAlphabetic(7);
        String lastName = RandomStringUtils.randomAlphabetic(5);
        firstNameTextBox.sendKeys(firstName);
        lastNameTextBox.sendKeys(lastName);
        streetTextBox.sendKeys("66");
        addressSuggestions.get(1).click();
        dobTextBox.sendKeys("12/12/1995");
        continuePersonalInfoButton.click();
    }
}
