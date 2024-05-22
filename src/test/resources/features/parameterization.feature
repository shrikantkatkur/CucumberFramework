Feature:Learning Paremeterization
Scenario: Step parameterization
Given I have two numbers 11 and 12
When I add them
Then print the result

Scenario: Passing list to step definition
Given I have following items:
|"Orange"|
|"Pineapple"|
|"Apple"|
|"Grape"|
Scenario: Passing list to step definition with key and value
Given I have following items with qty:
|"Orange"|1|
|"Pineapple"|2|
|"Apple"|3|
|"Grape"|4|
#Example of Data Driven Testing
Scenario Outline: This is my first data driven test case
Given I have following <fruits> <quantity>

Examples:
|fruits|quantity|
|"Orange"|1|
|"Pineapple"|2|
|"Apple"|3|
|"Grape"|4|