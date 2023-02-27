<h1 align="center"> :house_with_garden: Address-Consultation-API :house_with_garden: </h1>
<p align="center">
    <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
    <img src="https://img.shields.io/badge/Apache%20Maven-C71A36.svg?style=for-the-badge&logo=Apache-Maven&logoColor=white"/>
    <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/>
    <img src="https://img.shields.io/badge/JUnit5-25A162.svg?style=for-the-badge&logo=JUnit5&logoColor=white"/>
    <img src="https://img.shields.io/badge/Cucumber-23D96C.svg?style=for-the-badge&logo=Cucumber&logoColor=white"/>
    <img src="https://img.shields.io/badge/Swagger-85EA2D.svg?style=for-the-badge&logo=Swagger&logoColor=black"/>
<p>

<p align="justify">Source code for the Java Developer Challenge, which consists from building an API to send a zip code and retrieve its address, if the zip code exists.</p>

<h2 align="center"> :computer: Functional requirements :computer_mouse:	</h2>
<p align="justify">The following requirements can directly affect the user experience and must be considered when handling errors.</p>
<p align="justify">:heavy_check_mark: The sent zip code can have a mask or not</p>
<p align="justify">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp :heavy_check_mark: Check if the zip cod mask matches to the brazilian zip code pattern</p>

<p align="justify">:heavy_check_mark: In case of failure from the external API (Via Cep API), return an informative message</p>
<p align="justify">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp :heavy_check_mark: Valid zip code, but nonexistent (example: 99999999)</p>
    
<p align="justify">:heavy_check_mark: In case of failure from the consultation API, return an informative message</p>
<p align="justify">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp :heavy_check_mark: Validation for digits quantity (example: "950100100")</p>
<p align="justify">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp :heavy_check_mark: Validation for alphanumeric digits (example: "95010A10")</p>
<p align="justify">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp :heavy_check_mark: Validation for spaces (example: "95010 10")</p>

<p align="justify">:heavy_check_mark: Calculate the fare according to the zip code zone</p>

<h3 align="center"> :link: Desired API :gear: </h3>

```POST /v1/consulta-endereco```
<p align="justify">The request body must has an object containing the <b>CEP</b> property.</p>



```json
{
    "cep": "01001000"
}
```
```Response 200```
<p align="justify">If the sent zip code is valid, then the address will be returned and the response status code will be 200.</p>



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


```Response 400```
<p align="justify">If the sent zip code is not valid or is nonexistent, then the response body will contain a message and the response status code will be 400.</p>


```json
{
    "message": "The zip code cannot be empty."
}
```



<h2 align="center"> :hammer_and_wrench:	Non-functional requirements :toolbox: </h2>
<p align="justify">The following requirements do not directly affect the user experience, but are part of the technical requirements to compose the infrastructure and quality of the project.</p>
<p>:heavy_check_mark: Java 11</p>
<p>:heavy_check_mark: Spring Boot</p>
<p>:heavy_check_mark: API REST Template</p>
<p>:heavy_check_mark: Swagger Documentation</p>
<p>:heavy_check_mark: JUnit5 unity testing</p>
<p>:heavy_check_mark: Cucumber automated tests</p>

<h2 align="center"> :runner: Running the project :running_woman: </h2>
<p align="justify">To run the project successfully follow the steps below:</p>


<h3 align="center"> :arrow_down: Clone the project </h3>
<p align="justify">To clone the entire source code to run the project, type:</p>



```
git clone https://github.com/barbaraport/address-consultation-api.git
```



<h3 align="center"> :heavy_check_mark: Run the tests :heavy_check_mark: </h3>
<ol>
  <li>Be sure that you already have Java 11 installed and configured;
  <li>Open the project folder in the terminal;</li>
  <li>Execute all tests (from JUnit and Cucumber), typing:
</ol>



```
.\mvnw test
```



<h3 align="center"> Start the application :arrow_up: </h3>
<p align="justify">To execute the server application, type:</p>



```
.\mvnw spring-boot:run
```



<h3 align="center"> :books:	Access the Swagger UI </h3>
<p align="justify">If you want to see the API documentation, access the Swagger UI clicking <a href="http://localhost:8080/swagger-ui.html">here</a> or acessing it via the URL <a href="http://localhost:8080/swagger-ui.html">http://localhost:8080/swagger-ui.html</a></p>
<p align="justify"> :warning: Be sure that the server application is running! :warning:
