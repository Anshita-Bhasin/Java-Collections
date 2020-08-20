package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class OTPNumberTest {
    @FindBy(xpath = "//input[@name='firstname']")
    WebElement firstName;
    @FindBy(xpath = "//input[@name='lastname']")
    WebElement lastName;
    @FindBy(xpath = "//input[@name='reg_email__']")
    WebElement mobileNumber;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @FindBy(xpath = "//input[@name='birthday_day']")
    WebElement day;
    @FindBy(xpath = "//input[@name='birthday_month']")
    WebElement month;
    @FindBy(xpath = "//input[@name='birthday_year']")
    WebElement year;
    @FindBy(xpath = "//input[@name='sex']")
    WebElement gender;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;

    public OTPNumberTest() throws IOException {

        PageFactory.initElements(driver, this);
    }

    public static WebDriver driver;
    public static final String ACCOUNT_SID = "AC99705e0a8dfc9ef685f84aa458c14686";
    public static final String AUTH_TOKEN = "e2309e24450a589cb0fbc0d420ddc167";
    public static Properties prop;

    @BeforeTest
    public void setup() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/config/FB.properties");
        prop.load(fileInputStream);

    }

    @Test
    @Parameters({"mobilenumber"})
    public void readOTP(String mobilenumber) throws IOException {


        String name = prop.getProperty("firstName");
        driver.findElement(By.xpath("//div[@id='pageFooter']//a[text()='English (US)']")).click();

        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(prop.getProperty("firstName"));
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(prop.getProperty("lastName"));
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(mobilenumber);
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(prop.getProperty("password"));

        readValuesFromDropDown(driver.findElement(By.xpath("//select[@name='birthday_day']")), prop.getProperty("day"));
        readValuesFromDropDown(driver.findElement(By.xpath("//select[@name='birthday_month']")), prop.getProperty("month"));
        readValuesFromDropDown(driver.findElement(By.xpath("//select[@name='birthday_year']")), prop.getProperty("year"));

        driver.findElement(By.xpath("//input[@name='sex']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();


    }

    public static void readValuesFromDropDown(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);

    }

}
