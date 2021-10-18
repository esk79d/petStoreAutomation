package steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class AssertionSteps
{

    @Step
    public void verifySuccessStatusCode_201(int statusCode){
        Assert.assertEquals("Actual statusCode is not equal to the expected",201,statusCode);
    }

    @Step
    public void verifySuccessStatusCode_200(int statusCode){
        Assert.assertEquals("Actual statusCode is not equal to the expected",200,statusCode);
    }

    @Step
    public void verifyFailureStatusCode_400(int statusCode){
        Assert.assertEquals("Actual statusCode is not equal to the expected",400,statusCode);
    }

    @Step
    public void verifyMessage(String expectedValue, String actualValue){
        Assert.assertTrue(expectedValue.equals(actualValue));
    }

    @Step
    public void verifyFailureStatusCode_403(int statusCode){
        Assert.assertEquals("Actual statusCode is not equal to the expected", 403,statusCode);
    }

    @Step
    public void verifyFailureStatusCode_401(int statusCode){
        Assert.assertEquals("Actual statusCode is not equal to the expected", 401,statusCode);
    }
}
