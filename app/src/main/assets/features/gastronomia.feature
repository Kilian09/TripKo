Feature: Gastronomia

  @Gastronomia-feature
  Scenario Outline: Pasar a gastronomia screen
    Given iniciar splash screen
    And finalizar splash screen
    And iniciar menu screen
    And mostrar cabecera
    And mostrar boton despegable
    And mostrar "<menu_button>"
    When pulsar boton Gastronomia
    Then finalizar menu screen
    And iniciar gastronomia screen
    And mostrar cabecera
    And mostrar boton Despegable
    And mostrar boton  Home
    And mostrar imagen "<region>"
    And mostrar titulo "<region>"
    And mostrar boton OpcionesDespegable

    Examples:
    | menu_button                | region   |
    | conversion_de_moneda       | region1  |
    | sobre_corea_del_sur        | region2  |
    | idioma                     |          |
    | transporte                 |          |
    | entretenimiento            |          |
    | gastronomia                |          |
    | sitios_turisticos          |          |
    | contactos                  |          |


  @Gastronomia-feature
  Scenario Outline: Volver al MenuScreen a traves de gastronomia screen
    Given iniciar splash screen
    And finalizar splash screen
    And iniciar menu screen
    And mostrar cabecera
    And mostrar boton despegable
    And mostrar "<menu_button>"
    And pulsar boton Gastronomia
    And finalizar menu screen
    And iniciar gastronomia screen
    And mostrar cabecera
    And mostrar boton Despegable
    And mostrar boton Home
    And mostrar imagen "<region>"
    And mostrar titulo "<region>"
    And mostrar boton OpcionesDespegable
    When pulsar boton "<button>"
    Then finalizar gastronomia screen
    And resumir menu screen
    And mostrar cabecera
    And mostrar boton despegable
    And mostrar <menu_button>"

    Examples:
      | menu_button                | region   | button |
      | conversion_de_moneda       | region1  | back   |
      | sobre_corea_del_sur        | region2  | home   |
      | idioma                     |          |        |
      | transporte                 |          |        |
      | entretenimiento            |          |        |
      | gastronomia                |          |        |
      | sitios_turisticos          |          |        |
      | contactos                  |          |        |

