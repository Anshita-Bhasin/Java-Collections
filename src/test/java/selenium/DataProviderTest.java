package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.TestUtil;

public class DataProviderTest {

    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();

    }


    @Test(invocationCount=4,dataProvider = "testdata",priority = 0,enabled = false)
    public void searchCourse(String data) {
        WebElement searchText = driver.findElement(By.xpath("//input[@id='search']"));
        searchText.sendKeys(data);
        WebElement searchButton = driver.findElement(By.xpath("//button[@id=\"search-icon-legacy\"]"));
        searchButton.click();

        driver.findElement(By.xpath("//input[@id='search']")).clear();

    }

    @DataProvider(name = "testdata")
    public Object[][] searchData() {
        return new Object[][]
                {
                        {"Testing Java"},

                        {"selenium"}

                };
    }
    @Test(dataProvider = "linkData",priority = 1)
    public void searchPhone(String data) {
        WebElement searchText = driver.findElement(By.xpath("//input[@id='search']"));
        searchText.sendKeys(data);
        WebElement searchButton = driver.findElement(By.xpath("//button[@id=\"search-icon-legacy\"]"));
        searchButton.click();

        driver.findElement(By.xpath("//input[@id='search']")).clear();

    }

    @DataProvider
    public Object[][] linkData() {
        Object[][]data= TestUtil.readDataFromExcelFile("Youtube");
        return  data;

    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}
