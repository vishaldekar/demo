package com.app.RestDemo.stepsdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class RegistrationSteps {

    @When("user enter below details")
    public void user_enter_below_details(DataTable dataTable) {
       List<List<String>> list =  dataTable.asLists(String.class);

        for (List<String>  l :list) {
            System.out.println(l);
        }

    }

    @When("user enter below  details in map")
    public void user_enter_below_details_in_map(io.cucumber.datatable.DataTable dataTable) {
      List<Map<String,String>> maps =  dataTable.asMaps(String.class,String.class);

        for (Map<String,String> m: maps ) {
            System.out.println(m);
        }

    }

    @Then("user successfully registered")
    public void user_successfully_registered() {
    }

}
