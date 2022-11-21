
  @sprint001
  Feature:Validating the contact page

  @testcase01
  Scenario: validating the submit button without data in contact page
    Given user opened the browser and entered the url
    When from the homepage user click on contact
    And  user click on submit button
    And verify the mandatory fields are populating with the error  messages
    Then verify the error messages are gone with valid data

  @testcase02
  Scenario: validating the positive submit functionality in contact page
    Given user opened the browser and entered the url
    When from the homepage user click on contact
    And  user click on submit button
    And verify the mandatory fields are populating with the error  messages
    And give the corresponding valid data and click on submit button
    Then  validate the successful submission message

  @testcase03
  Scenario: validating the cart page
    Given user opened the browser and entered the url
    When  click on Start Shopping button
    And click two times on Stuffed Frog,five times on Fluffy Bunny and three times on valentine Bear
    And    Go to the cart page
    Then   Verify that total is equal to the sum of subtotals



