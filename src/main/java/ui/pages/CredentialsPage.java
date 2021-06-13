package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.framework.TestBase;

import java.util.logging.Logger;

public class CredentialsPage extends TestBase {

    WebDriver driver;
    public final String DEFAULT_PASSWORD = "123Password";
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(CredentialsPage.class));

    public CredentialsPage(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    public WebElement emailTextBox;

    @FindBy(name = "password")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//input[@name='agreements']/following-sibling::div[1]")
    public WebElement aggreementsCheckBox;

    @FindBy(xpath = "//button[contains(text(),'Check Your Rate')]")
    public WebElement checkYourRateButton;

    public void clickAggreementsCheckbox() throws InterruptedException {
        Boolean isChecked = aggreementsCheckBox.isSelected();
        if(! isChecked) {
            click(aggreementsCheckBox);
        }
    }

    public String fillCredentials() throws InterruptedException {
        LOGGER.info("Filing the User Credentials");
        String email = email();
        emailTextBox.sendKeys(email);
        LOGGER.info(String.format("Email for the User -----> %s",email));
        passwordTextBox.sendKeys(DEFAULT_PASSWORD);
        clickAggreementsCheckbox();
        checkYourRateButton.click();
        LOGGER.info("Entered Credentials and checked rate");
        return email;
    }
}
