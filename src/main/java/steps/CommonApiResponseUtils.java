package steps;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

public class CommonApiResponseUtils {
    @Step
    public int getStatusCode(Response rsp){
        return rsp.getStatusCode();
    }
}
