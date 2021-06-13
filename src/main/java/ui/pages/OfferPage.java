package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.framework.TestBase;
import ui.utilities.LoanApprovalDetails;

public class OfferPage extends TestBase {

    WebDriver driver;

    public OfferPage(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@data-auto='userLoanAmount']")
    public WebElement loanAmountValue;

    @FindBy(xpath = "//*[contains(text(),'Monthly Payment')]/following-sibling::div")
    public WebElement monthlyPayment;

    @FindBy(xpath = "//*[contains(text(),'Term')]/following-sibling::div")
    public WebElement term;

    @FindBy(xpath = "//*[contains(text(),'Interest')]/following-sibling::div")
    public WebElement interestRate;

    @FindBy(xpath = "//*[contains(text(),'APR')]/following-sibling::div")
    public WebElement apr;

    @FindBy(xpath = "//*[@aria-label='Open Site Menu']")
    public WebElement hamburgerMenu;

    @FindBy(linkText = "Sign Out")
    public WebElement signOut;

    public LoanApprovalDetails captureLoanApprovalDetails() throws InterruptedException {
        LoanApprovalDetails loanApprovalDetails = new LoanApprovalDetails();
        loanApprovalDetails.setLoanAmount(loanAmountValue.getText());
        loanApprovalDetails.setMonthlyPayment(monthlyPayment.getText());
        loanApprovalDetails.setIntrestRate(interestRate.getText());
        loanApprovalDetails.setTerm(term.getText());
        loanApprovalDetails.setApr(apr.getText());
        logout();
        return loanApprovalDetails;
    }

    public void logout() throws InterruptedException {
        click(hamburgerMenu);
        click(signOut);
    }
}
