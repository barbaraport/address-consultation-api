# address-consultation-api

Source code for the Java Developer Challenge.

## Functional requirements

:heavy_check_mark: Send a zip code to consult its address

:heavy_check_mark: The sent zip code can have a mask or not

:heavy_check_mark: Calculate the fare

:heavy_check_mark: In case of failure from the external API (Via Cep API), return an informative message

:heavy_check_mark: Valid zip code, but inexistent (example: 99999999)
    
:heavy_check_mark: In case of failure from the consultation API, return an informative message

:heavy_check_mark: Validation for digits quantity (example: "950100100")

:heavy_check_mark: Validation for alphanumeric digits (example: "95010A10")

:heavy_check_mark: Validation for spaces (example: "95010 10")

:heavy_check_mark: Validation for zip code mask


## Non-functional requirements

:heavy_check_mark: Java 11

:heavy_check_mark: Spring Boot

:heavy_check_mark: API REST Template

:x: Swagger Documentation

:heavy_check_mark: JUnit5 Unitary tests

:x: Cucumber automated tests


### Desired API

POST v1/consulta-endereco
REQUEST

```json
{
    "cep": "01001000"
}
```

RESPONSE HTTP 200

```json
{
    "cep": "01001-000",
    "rua": "Praça da Sé",
    "complemento": "lado ímpar",
    "bairro": "Sé",
    "cidade": "São Paulo",
    "estado": "SP",
    "frete": 7.85
}
```
