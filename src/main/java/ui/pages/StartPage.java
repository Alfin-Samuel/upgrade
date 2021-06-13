package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import ui.framework.TestBase;

public class StartPage extends TestBase {

    WebDriver driver;

    public StartPage(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[contains(text(),'Loan Amount')]/../input")
    public WebElement loanAmountTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement checkYourRateButton;

    @FindBy(xpath = "//select[@aria-label='Loan Purpose']")
    public WebElement loanPurposeDropDown;

    public void selectLoanPurpose(String option) {
            Select loanPurpose = new Select(loanPurposeDropDown);
        loanPurpose.selectByVisibleText(option);
    }

    public void checkRateAfterEnteringValues(String loanAmount, String loanPurpose) throws InterruptedException {
        loanAmountTextBox.clear();
        loanAmountTextBox.sendKeys(loanAmount);
        selectLoanPurpose(loanPurpose);
        click(checkYourRateButton);
    }

}

