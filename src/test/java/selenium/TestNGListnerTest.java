package selenium;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static utils.TestUtil.initialization;
import static utils.TestUtil.teardown;

public class TestNGListnerTest {

    SoftAssert softAssert = new SoftAssert();


    @BeforeMethod
    public void setUp() {
        initialization();

    }


    @Test()
    public void ListenerTest() {
        Assert.assertEquals(true, false);


    }

    @AfterMethod
    public void afterMethod() {
        teardown();

    }

}

