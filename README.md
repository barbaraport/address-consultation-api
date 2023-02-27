<h1 align="center"> :house_with_garden: Address-Consultation-API :house_with_garden: </h1>

<p align="justify">Source code for the Java Developer Challenge, which consists from building an API to send a zip code and retrieve its address, if the zip code exists.</p>

<h2 align="center"> :computer: Functional requirements :computer_mouse:	</h2>

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

<h3 align="center"> :link: Desired API :gear: </h3>

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


<h2 align="center"> :hammer_and_wrench:	Non-functional requirements :toolbox: </h2>

:heavy_check_mark: Java 11

:heavy_check_mark: Spring Boot

:heavy_check_mark: API REST Template

:heavy_check_mark: Swagger Documentation

:heavy_check_mark: JUnit5 Unitary tests

:x: Cucumber automated tests
