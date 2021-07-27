import java.util.ArrayList;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import io.restassured.http.ContentType;



public class LoanAsk {

    public static void main(String[] args) {
        String payload = "{ \"bankAccount\": { \"accountNumber\": 1234567890, \"bankName\": \"SCRUM_BANK\" }, \"idNumber\": 9901025391080, \"name\": \"Pontsho\", \"surname\": \"Molewa\"}";

        RestAssured.baseURI = "http://localhost:8080";

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Content-Type","application/json");

        Response response = httpRequest.body(payload).post("/loans");

        int statusCode = response.getStatusCode();
        String resp = response.asString();
        System.out.println("Response status code is "+statusCode);
        System.out.println(resp);


    }
}


