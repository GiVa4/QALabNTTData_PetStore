@ProbarFeatureMascota
Feature: Mascota

  @crerMascota
  Scenario: Crear Mascota

  @consultarMascota
  Scenario: Consultar Mascota
    When consulto la tienda de mascota con IDMASCOTA 2467
    Then valido el codigo de respuesta sea 404
    And valido la respuesta sea "Pet not found"
