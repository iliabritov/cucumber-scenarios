Feature: To verify our endpoint

    Scenario: Verify that user can search only member of his own company
        Given I want to execute users endpoint
        When I submit GET request as ilia from 111 company to get info about ivan user from 111 company
        Then I should get Status code is 200
        But I submit GET request as ilia from 111 company to get info about sasha user from 222 company
        And I should get Status code is 403