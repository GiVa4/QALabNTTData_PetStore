package com.nttdata.steps;

import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

public class MascotaStep {

    private String URL_BASE = "https://petstore.swagger.io/v2/";


    public void consulta(int idMascota) {


        System.out.println("Consultar Mascota");

        SerenityRest.given()
                .baseUri(URL_BASE)
                .relaxedHTTPSValidation()
                .log().all()
                .when()
                .get("pet/" + String.valueOf(idMascota))
                .then()
                .log().all()
                ;
    }

    public void validarStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, SerenityRest.lastResponse().getStatusCode());
    }

    public void validoRespuesta(String msg) {
        String respuesta = SerenityRest.lastResponse().getBody().path("message");
       Assert.assertEquals(msg, respuesta);
    }
}
