# address-consultation-api

Source code for the Java Developer Challenge

## Functional requirements

- Send a zipcode to consult its address
- The zipcode can have a mask or not
- In case of failure, return a informative message

## Non-functional requirements

- Java 11
- Spring Boot
- API REST Template
- Swagger Documentation
- JUnit5 Unitary tests
- Cucumber automated tests

### Desired API

```json
POST v1/consulta-endereco
REQUEST
{
    "cep": "01001000"
}

RESPONSE HTTP 200
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