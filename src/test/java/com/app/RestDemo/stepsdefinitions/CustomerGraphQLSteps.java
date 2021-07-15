package com.app.RestDemo.stepsdefinitions;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.micrometer.core.instrument.util.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CustomerGraphQLSteps {

    @Autowired
    GraphQLTestTemplate graphQLTestTemplate;

    GraphQLResponse graphQLResponse;

    private static final String GRAPHQL_QUERY_PATH = "graphqltest/query/customer.graphql";
    private  static final String GRAPHQL_QUERY_RESPONSE_PATH = "graphqltest/query/response.json";

    @When("user makes request to allCustomers")
    public void userMakesRequestToAllCustomers() throws IOException {
        graphQLResponse =
               graphQLTestTemplate.postForResource(GRAPHQL_QUERY_PATH);
    }

    @Then("user receives {int} as response code")
    public void userReceivesAsResponseCode(int response) {

        assertEquals(response,graphQLResponse.getStatusCode().value());
    }


    @Then("user receives list of customers in response")
    public void userReceivesListOfCustomersInResponse() throws IOException, JSONException {
        var expectedResponseBody = read(GRAPHQL_QUERY_RESPONSE_PATH);
        JSONAssert.assertEquals(expectedResponseBody,graphQLResponse.getRawResponse().getBody(),true);
    }

    public String read(String graphqlQueryResponsePath) throws IOException {
        return IOUtils
                .toString(new ClassPathResource(graphqlQueryResponsePath).getInputStream(), StandardCharsets.UTF_8);
        }

}
