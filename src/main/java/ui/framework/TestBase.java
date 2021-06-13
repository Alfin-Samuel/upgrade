package ui.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;

    /**
     * This method will open the URL mentioned in the input.properties file
     * @param browser This parameter is used to mention browser in which URL need to be maintained
     * @throws IOException
     */

    public void openURL(String browser) throws IOException, IOException {
        String currentDir = System.getProperty("user.dir");
        File file = new File(currentDir+"/input.properties");
        String canonicalPath=file.getCanonicalPath();
        Properties prop=new Properties();
        FileInputStream fis=new FileInputStream(canonicalPath);
        prop.load(fis);
        String browserToUse=browser;

        if(browserToUse.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
            driver = new FirefoxDriver();

        }
        else if (browserToUse.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            driver=new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        }
        driver.manage().window().maximize();
        driver.get(prop.getProperty("URL"));
    }

    public WebDriver getDriver() {
        return driver;

    }
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isExists(WebElement e) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(e));
        boolean result=false;
        if(e.isDisplayed()){
            result=true;}
        return result;
    }
    public static String email(){
        String name="candidate"+System.currentTimeMillis();
        String email=name+"@upgrade-challenge.com";
        return email;
    }
    public void click(WebElement e) throws InterruptedException {
        if(isExists(e)){
            e.click();
        }
    }
    public void enterText(WebElement e,String text) throws InterruptedException {
        e.clear();
        e.sendKeys(text);

    }

}
