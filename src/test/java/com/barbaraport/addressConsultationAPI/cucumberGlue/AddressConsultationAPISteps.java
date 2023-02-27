package com.barbaraport.addressConsultationAPI.cucumberGlue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberContextConfiguration
public class AddressConsultationAPISteps {

    @LocalServerPort
    String port;

    ResponseEntity<?> lastResponse;

    @When("the zip code {string} is sent")
    public void sendZipCode(String zipCode) throws JSONException {
        try {
            RestTemplate restTemplate = new RestTemplate();

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(
                    "http://localhost:" + port + "/v1/consulta-endereco"
            );

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            JSONObject request = new JSONObject();
            request.put("cep", zipCode);

            HttpEntity<String> entity = new HttpEntity<>(request.toString(), headers);

            this.lastResponse = restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.POST,
                    entity,
                    String.class
            );
        } catch (HttpClientErrorException exception) {
            this.lastResponse = ResponseEntity
                    .status(exception.getRawStatusCode())
                    .body(exception.getResponseBodyAsString()
                    );
        }
    }

    @Then("no errors are thrown")
    public void noErrorsAreThrown() {
        assertEquals(200, this.lastResponse.getStatusCodeValue());
    }

    @Then("an error is thrown")
    public void anErrorIsThrown() {
        assertEquals(400, this.lastResponse.getStatusCodeValue());
    }

    @Then("the address should be returned")
    public void theAddressShouldBeReturned() throws JSONException {
        JSONObject responseBody = new JSONObject(
                Objects.requireNonNull(this.lastResponse.getBody()).toString()
        );

        assertTrue(responseBody.has("cep"));
        assertTrue(responseBody.has("rua"));
        assertTrue(responseBody.has("complemento"));
        assertTrue(responseBody.has("bairro"));
        assertTrue(responseBody.has("cidade"));
        assertTrue(responseBody.has("estado"));
        assertTrue(responseBody.has("frete"));
    }

    @And("the fare should be {string}")
    public void theFareShouldBe(String expectedFare) throws JSONException {
        JSONObject responseBody = new JSONObject(
                Objects.requireNonNull(this.lastResponse.getBody()).toString()
        );
        double actualFare = responseBody.getDouble("frete");

        assertEquals(Double.valueOf(expectedFare), actualFare);
    }

    @And("the message is {string}")
    public void theMessageIs(String expectedMessage) throws JSONException {
        JSONObject responseBody = new JSONObject(
                Objects.requireNonNull(this.lastResponse.getBody()).toString()
        );
        String actualMessage = responseBody.getString("message");

        assertEquals(expectedMessage, actualMessage);
    }
}
