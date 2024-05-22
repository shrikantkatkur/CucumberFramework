Feature: Product Result Search Page
Scenario: Verify Product Brand Functionality
#Given क्रोम ब्राउज़र खोले 
#And application is launched successfully in browser
When user search the product
And Click on product image
And Enter Valid pincode and click on check
Then should accept valid pincode
#And Close the Tab