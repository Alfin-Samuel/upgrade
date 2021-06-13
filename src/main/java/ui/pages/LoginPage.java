package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.framework.TestBase;

public class LoginPage extends TestBase {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//button[@data-auto='login']")
    public WebElement signInToAccountButton;

    public void loginToAccout(String userName, String password) throws InterruptedException {
        enterText(emailTextBox,userName);
        enterText(passwordTextBox, password);
        click(signInToAccountButton);
    }
}
