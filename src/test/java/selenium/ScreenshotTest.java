package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ListenerTest;

import static utils.TestUtil.initialization;


@Listeners(ListenerTest.class)
public class ScreenshotTest {


    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        initialization();

    }


    @Test()
    public void search() {
        WebElement searchText = driver.findElement(By.xpath("//input[@id='search']"));
        searchText.sendKeys("");


    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}

