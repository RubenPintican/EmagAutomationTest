Meta:

Narrative:
As a user
I want to search for a product on eMag and I want to see if the discount price is correct
So that I can see the result

Scenario: Search for specific product on Emag and check discount after I Log-In in my account.
Given I go to eMag home page
When I LogIn on eMag and I complete my account details
When I search for Huawei P20 Pro on eMag
Then I verify if the oldprice:3.89999 Lei newprice:3.39999 Lei discount:(- 12% ) for product is correct

