Meta:

Narrative:
As a user
I want to search for a product on Cel.ro and I want to see if the discount price is correct
So that I can see the result

Scenario: Search for specific product on Cel and check discount after I Log-In in my account.
Given I go to Cel home page
When I LogIn on Cel
When I search for <phoneName> on Cel
Then I verify if the old price:<oldPrice> new price:<newPrice> discount:<discount> for product is correct
Then I LogOut from my Account

Examples:

|phoneName|oldPrice|newPrice|discount|
|iPhone X|5999|5599|400|
|Samsung Galaxy S9|4699|3999|700|
|Huawei P20 Pro|3899|3399|500|

