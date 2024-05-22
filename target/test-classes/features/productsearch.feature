Feature: Product Search Page
Scenario: Verify Product Search Result when user enters valid product in search box
#Given क्रोम ब्राउज़र खोले 
#And application is launched successfully in browser
When user search the product
Then User should get desired result

Scenario: Verify Product Search Result when user enters Invalid product in search box
#Given क्रोम ब्राउज़र खोले 
#And application is launched successfully in browser
When user search Invalid the product
Then User should get Invalid search message "We couldn't find any matches"

