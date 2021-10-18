package steps;

import config.Environment;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import utils.LoggerFactory;

import java.util.Objects;

public class PetStoreServiceSteps {
    private static final LoggerFactory logger = new LoggerFactory(PetStoreServiceSteps.class);
    private String petStoreServiceUrl = Environment.getPetStoreServiceUrl();
    private String petID = Environment.getPetID();

    public Response createNewPetWithJsonBody(String body) {
        Response response= SerenityRest
                .given()
                .body(body)
                .header("Content-Type",  "application/json")
                .headers("accept","application/xml")
                .when()
                .post(petStoreServiceUrl);
        logger.info(response.body().asString());
        return response;
    }
    public Response createNewPetWithXmlBody(String body) {
        Response response= SerenityRest
                .given()
                .body(body)
                .header("Content-Type",  "application/xml")
                .when()
                .post(petStoreServiceUrl);
        return response;
    }

    public Response updatePetDetails(String body) {
        Response response= SerenityRest
                .given()
                .body(body)
                .header("Content-Type",  "application/json")
                .headers("accept","application/xml")
                .when()
                .put(petStoreServiceUrl);
        return response;
    }
    public Response getPetDetails(String attribute) {
        String endPoint=petStoreServiceUrl;
        if(Objects.equals(attribute, "ID")){endPoint=petStoreServiceUrl+"/"+petID;}
        Response response= (Response) SerenityRest
                .given()
                .header("Content-Type",  "application/json")
                .headers("accept","application/xml")
                .when()
                .get(endPoint) ;
        return response;
    }

    public Response deletePetDetails() {
        String endPoint=petStoreServiceUrl+"/"+petID;
        Response response= SerenityRest
                .given()
                .header("Content-Type",  "application/json")
                .headers("accept","application/xml")
                .when()
                .delete(endPoint);
        return response;
    }
}
