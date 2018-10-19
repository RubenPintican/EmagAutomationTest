Meta:

Narrative:
As a user
I want to search for a product on eMag and I want to see if the discount price is correct
So that I can see the result

Scenario: Search for specific product on Emag and check discount after I Log-In in my account.
Given I go to eMag home page
When I LogIn on eMag and I complete my account details
When I search for <productName> on eMag
Then I verify if the oldprice:<oldPrice> newprice:<newPrice> discount:<discount> for product is correct

Examples:

|productName|oldPrice|newPrice|discount|
|iPhone X|5.39989 Lei|4.89999 Lei|- 10%|
|Samsung Galaxy S9|3.89999 Lei|2.99999 Lei|- 10%|



