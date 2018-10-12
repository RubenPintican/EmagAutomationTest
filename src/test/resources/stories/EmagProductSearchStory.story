Meta:

Narrative:
As a user
I want to search for a product on eMag and I want to see if the discount price is correct
So that I can see the result

Scenario: Search for specific product on Emag and check discount
Given I load test data
When I SingIn on eMag
When I search for iPhone X on eMag
Then I verify if the oldprice:5.49999 Lei newprice:4.89999 Lei discount:(- 10% ) for product is correct