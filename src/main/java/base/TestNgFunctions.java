package base;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class TestNgFunctions {

    private SoftAssert softAssert;

    public TestNgFunctions() {
        this.softAssert = new SoftAssert();
    }

    public void assertTrue(boolean condition, String message) {
        try {
            Assert.assertTrue(condition, message);
        } catch (AssertionError e) {
            softAssert.fail(message);
        }
    }

    public void assertEquals(Object actual, Object expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            softAssert.fail(message);
        }
    }

    public void assertAll() {
        softAssert.assertAll();
    }
}
