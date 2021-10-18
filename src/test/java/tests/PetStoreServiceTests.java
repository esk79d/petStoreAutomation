package tests;

import config.Environment;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.w3c.dom.Document;
import steps.CommonApiResponseUtils;
import steps.PetStoreServiceSteps;
import utils.JsonUtils;
import utils.LoggerFactory;
import utils.XmlUtils;

import java.io.File;

import static io.restassured.RestAssured.given;

@RunWith(SerenityRunner.class)

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PetStoreServiceTests {

    private static final LoggerFactory logger = new LoggerFactory(PetStoreServiceTests.class);
    @Steps
    CommonApiResponseUtils commonApiResponseUtils;
    @Steps
    PetStoreServiceSteps petStoreServiceSteps;
    private String addNewPetJsonFilePath = Environment.addNewPetJsonFilePath();
    private String addNewPetXmlFilePath = Environment.addNewPetXmlFilePath();
    private String updatePetNameJsonFilePath = Environment.updatePetNameJsonFilePath();
    private String updatePetStatusJsonFilePath = Environment.updatePetStatusJsonFilePath();

    @Steps
    JsonUtils jsonUtils= new JsonUtils();
    XmlUtils xmlUtils = new XmlUtils();

    @Test
    public void createNewPetUsingJsonBody(){
        String jsonBody = jsonUtils.generateStringFromResource(addNewPetJsonFilePath);
        Response response = petStoreServiceSteps.createNewPetWithJsonBody(jsonBody);
        ResponseBody body= response.body();
        Assert.assertEquals(200, commonApiResponseUtils.getStatusCode(response));
        Assert.assertEquals("7001",response.xmlPath().get("Pet.id"));
        Assert.assertEquals("Test Dog",response.xmlPath().get("Pet.name"));
        Assert.assertEquals("available",response.xmlPath().get("Pet.status"));
        Assert.assertEquals("1",response.xmlPath().get("Pet.category.id"));
        Assert.assertEquals("Dogs",response.xmlPath().get("Pet.category.name"));
    }

    @Test
    public void createNewPetUsing1XmlBody(){
        Document data = xmlUtils.convertXMLFileToXMLDocument(addNewPetXmlFilePath);
        Response response = petStoreServiceSteps.createNewPetWithXmlBody(xmlUtils.convertDocToString(data));
        ResponseBody body= response.body();
        Assert.assertEquals(200, commonApiResponseUtils.getStatusCode(response));
        int petID=response.jsonPath().get("id");
        String petName=response.jsonPath().get("name"),petStatus=response.jsonPath().get("status");
        Assert.assertEquals(8001,petID);
        Assert.assertEquals("Xml Dog",petName);
        Assert.assertEquals("available",petStatus);
    }

    @Test
    public void updatePetName(){
        String jsonBody = jsonUtils.generateStringFromResource(updatePetNameJsonFilePath);
        System.out.println("jsonBody is" +jsonBody );
        Response response = petStoreServiceSteps.updatePetDetails(jsonBody);
        ResponseBody body= response.body();
        Assert.assertEquals(200, commonApiResponseUtils.getStatusCode(response));
        Assert.assertEquals("Test Dog1",response.xmlPath().get("Pet.name"));
    }
    @Test
    public void updatePetStatus(){
        String jsonBody = jsonUtils.generateStringFromResource(updatePetStatusJsonFilePath);
        Response response = petStoreServiceSteps.updatePetDetails(jsonBody);
        ResponseBody body= response.body();
        Assert.assertEquals(200, commonApiResponseUtils.getStatusCode(response));
        Assert.assertEquals("Test Dog1",response.xmlPath().get("Pet.name"));
        Assert.assertEquals("sold",response.xmlPath().get("Pet.status"));
    }

    @Test
    public void getPetDetailsByID(){
        Response response = petStoreServiceSteps.getPetDetails("ID");
        ResponseBody body= response.body();
        Assert.assertEquals(200, commonApiResponseUtils.getStatusCode(response));
        Assert.assertEquals("7001",response.xmlPath().get("Pet.id"));
        Assert.assertEquals("Test Dog",response.xmlPath().get("Pet.name"));
        Assert.assertEquals("available",response.xmlPath().get("Pet.status"));
    }
    @Test
    public void zdeletePetDetails(){
        Response response = petStoreServiceSteps.deletePetDetails();
        ResponseBody body= response.body();
        Assert.assertEquals(200, commonApiResponseUtils.getStatusCode(response));
        Assert.assertEquals("Pet deleted", body.asString());
    }
   }

