package com.app.RestDemo.stepsdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VersionSteps {


    String url = "http://localhost:8080/test/version";

    TestRestTemplate testRestTemplate = new TestRestTemplate();

    ResponseEntity<String>  response;


    @When("the client calls \\/version")
    public void theClientCallsVersion() {
        response = testRestTemplate.getForEntity(url,String.class);
    }

    @Then("the client receives status code of {int}")
    public void the_client_receives_status_code_of(Integer status) {
        assertEquals(status,response.getStatusCode().value());
    }

    @Then("the client receives server version {string}")
    public void the_client_receives_server_version(String version) {
        //assertEquals(response.getBody(),version);
        assertEquals(version,response.getBody());
    }

}
