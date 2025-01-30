package com.nttdata.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.time.Instant;

public class OrderStep {

    private static String URL = null;
    private static String CREATE_ORDER = "https://petstore.swagger.io/v2/store/order";
    Response response;

    public void getURL(String url) { URL = url; }

    @Step("Crear pedido {0} en PetStore")
    public void addOrder(int petId, int quantity, String status){
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"petId\": \""+petId+"\",\n" +
                        "  \"quantity\": \""+quantity+"\",\n" +
                        "  \"shipDate\": \""+ Instant.now().toString()+"\",\n" +
                        "  \"status\": \""+status+"\",\n" +
                        "  \"complete\": \""+true+"\"\n" +
                        "}")
                .log().all()
                .post(CREATE_ORDER)
                .then()
                .log().all()
                ;
    }

    public void getOrder(int orderId){
        SerenityRest.given()
                .contentType("application/json")
                .log().all()
                .get(URL+"/store/order/"+orderId)
                .then()
                .log().all()
        ;
    }

    public void validateStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, SerenityRest.lastResponse().getStatusCode());
    }

    public void validateResponseBody(int petId, int quantity, String status) {
        int idMascota = SerenityRest.lastResponse().getBody().path("petId");
        int cantidad = SerenityRest.lastResponse().getBody().path("quantity");
        String estado = SerenityRest.lastResponse().getBody().path("status");

        Assert.assertEquals(petId, idMascota);
        Assert.assertEquals(quantity, cantidad);
        Assert.assertEquals(status, estado);
    }
}
