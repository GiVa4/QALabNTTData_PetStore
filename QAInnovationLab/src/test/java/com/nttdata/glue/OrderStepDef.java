package com.nttdata.glue;

import com.nttdata.steps.OrderStep;
import cucumber.api.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.Date;

public class OrderStepDef {

    @Steps
    OrderStep order;

    @Given("Url {string} del servicio")
    public void url_del_servicio(String url) {
        order.getURL(url);
    }

    @When("Creo un nuevo pedido con petId {int}, quantity {int}, status {string}")
    public void creoUnNuevoPedidoConPetIdQuantityStatus(int petId, int quantity, String status) {
        order.addOrder(petId, quantity, status);
    }

    @When("Consulto por información del pedido con Id {int}")
    public void consulto_por_informacion_del_pedido_con_Id(int orderId) {
        order.getOrder(orderId);
    }
    

    @Then("Valido el código de respuesta sea {int}")
    public void validoElCódigoDeRespuestaSea(int statusCode) {
        order.validateStatusCode(statusCode);
    }

    @Then("Valido que la respuesta tenga petId {int}, quantity {int} y status {string}")
    public void validoQueLaRespuestaTengaPetIdQuantityYStatus(int petId, int quantity, String status) {
        order.validateResponseBody(petId, quantity, status);
    }
}
