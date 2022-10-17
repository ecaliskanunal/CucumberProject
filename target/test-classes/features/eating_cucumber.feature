@eating
Feature: Eating too many cucumbers may not be good for you.
  User Story: Eating too much of anything may not be good for you.

  @eating
  Scenario: Eating a few is no problem.
    Given John is hungry
    When He eats 3 cucumbers
    Then He is full