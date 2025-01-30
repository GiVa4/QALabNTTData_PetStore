@probarFeatureOrder
Feature: Order

  @crearPedido
  Scenario Outline: Crear Pedido
    Given Url "https://petstore.swagger.io/v2" del servicio
    When Creo un nuevo pedido con petId <petId>, quantity <quantity>, status "<status>"
    Then Valido el código de respuesta sea <statusCode>
    And Valido que la respuesta tenga petId <petId>, quantity <quantity> y status "<status>"
    Examples:
    | petId |quantity | status   | statusCode |
    | 1     | 1       | Complete | 200        |
    | 1     | 1       | Pending  | 200        |
    | 2     | 2       | Cancel   | 200        |
    | 3     | 7       | Cancel   | 200        |
    | 4     | 10      | Complete | 200        |

  @consultarPedido
  Scenario Outline: Consultar Pedido
    Given Url "https://petstore.swagger.io/v2" del servicio
    When Consulto por información del pedido con Id <orderId>
    Then Valido el código de respuesta sea <statusCode>
    And Valido que la respuesta tenga petId <petId>, quantity <quantity> y status "<status>"
    Examples:
      | orderId | statusCode | petId    | quantity | status |
      | 2       | 200        | 2        | 0        | placed |
      | 5       | 200        | 6        | 300      | placed |
      | 8       | 200        | 7        | 9        | placed |
      | 9       | 200        | 5        | 1        | placed |
      | 10      | 200        | 123      | 10       | approved |
