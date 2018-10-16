Meta:

Narrative:
As a user
I want to search for a product on Cel.ro and I want to see if the discount price is correct
So that I can see the result

Scenario: Search for specific product on Emag and check discount
Given I load test data
When I SingIn on Cel
When I search for iPhone X on Cel
Then I verify if the oldprice:5999 newprice:5399 discount:600 for product is correct