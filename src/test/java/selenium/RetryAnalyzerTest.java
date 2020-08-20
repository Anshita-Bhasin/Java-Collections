package selenium;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static utils.TestUtil.initialization;
import static utils.TestUtil.teardown;

public class RetryAnalyzerTest {

    SoftAssert softAssert = new SoftAssert();


    @BeforeMethod
    public void setUp() {
        initialization();

    }


    @Test(retryAnalyzer = utils.RetryTest.class)
    public void retryLogic() {

        Assert.assertEquals(true, false);


    }

    @AfterMethod
    public void end() {
        teardown();
    }

}

