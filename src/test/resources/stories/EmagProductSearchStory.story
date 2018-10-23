Meta:

Narrative:
As a user
I want to search for a product on eMag and I want to see if the discount price is correct
So that I can see the result

Scenario: Search for specific product on Emag and check discount after I Log-In in my account.

Given I go to eMag home page
When I search for <productName> on eMag
Then I verify if the old price:<oldPrice> new price:<newPrice> discount:<discount> for product is correct

Examples:

|productName|oldPrice|newPrice|discount|
|iPhone X|5.49999 Lei|4.89999 Lei|(- 10% )|
|Samsung Galaxy S9|3.59999 Lei|2.49999 Lei|(- 30% )|
|Huawei P20 Pro|1.69999 Lei|1.29990 Lei|(- 23% )|