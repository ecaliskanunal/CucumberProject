package com.cydeo.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EatingCucumber {
    @Given("John is hungry")
    public void john_is_hungry() {
        System.out.println("from Given");
    }
    @When("He eats {int} cucumbers")
    public void he_eats_cucumbers(Integer int1) {
        System.out.println("from When");
    }
    @Then("He is full")
    public void he_is_full() {
        System.out.println("from Then");
    }
}
