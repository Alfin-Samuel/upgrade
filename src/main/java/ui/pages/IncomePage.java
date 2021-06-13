package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.framework.TestBase;

import java.util.logging.Logger;

public class IncomePage extends TestBase {

    WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(IncomePage.class));

    public IncomePage(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name="borrowerIncome")
    public WebElement incomeTextBox;

    @FindBy(name="borrowerAdditionalIncome")
    public WebElement additionalTextBox;

    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    public WebElement continueIncomePageButton;

    public void enterIncomeDetails() throws InterruptedException {
        LOGGER.info("Entering the income Details .........");
        enterText(incomeTextBox,"120000");
        enterText(additionalTextBox,"5000");
        click(continueIncomePageButton);
        click(continueIncomePageButton);
    }

}
