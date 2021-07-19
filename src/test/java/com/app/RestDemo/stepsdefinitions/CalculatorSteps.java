package com.app.RestDemo.stepsdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorSteps {

    private int add ;

    private String URL = "http://localhost:8081";

    TestRestTemplate testRestTemplate = new TestRestTemplate();

    ResponseEntity<Integer> responseEntity;

    @When("user gives two numbers {int} and {int}")
    public void user_gives_two_numbers_and(Integer int1, Integer int2) {
       responseEntity = testRestTemplate.getForEntity(URL + "/calc/add/"+int1+"/"+int2, Integer.class );
    }

    @Then("user expects {int} in response")
    public void user_expects_in_response(Integer int1) {
       assertEquals(int1,responseEntity.getBody());
    }


    @When("user gives GET \\/calc\\/sub two numbers {int} and {int}")
    public void userGivesGETCalcSubTwoNumbersAnd(int arg0, int arg1) {
        responseEntity = testRestTemplate.getForEntity(URL + "/calc/sub/"+arg0+"/"+arg1, Integer.class );
    }

    @Then("user expects result as {int} in response")
    public void user_expects_result_as_in_response(Integer int1) {
        assertEquals(int1 , responseEntity.getBody());
        assertEquals(200,responseEntity.getStatusCode().value());
    }



}
