Feature: Home And Different Elements Pages Test

  Scenario: Different Elements Page Test
    Given I open EPAM JDI site Home page
    Then Title should be 'HOME_PAGE_TITLE'
    When I login as 'PITER'
    Then Username should be as for 'PITER'
    And There are 4 images, texts, headline and description
    When I click on Service in the header
    Then Service dropdown menu contains all options:
      | SUPPORT       |
      | DATES         |
      | COMPLEX_TABLE |
      | SIMPLE_TABLE  |
      | USER_TABLE    |
      | TABLE_PAGES   |
      | DIFFERENT     |
      | PERFORMANCE   |
    When I click on Service in the left section
    Then Left Service dropdown menu contains all same options like in the header Service
    When I open 'Different elements' Page
    Then I check that Different Elements page contains all need elements
    Then I check that Right section is displayed
    When I select necessary checkboxes
      | WATER |
      | WIND  |
    Then I check that there is a log for selected checkboxes
      | WATER |
      | WIND  |
    When I click on radio 'SELEN'
    Then I check that there is a log for 'SELEN' radio
    When I click on colors dropdown
    When I select 'YELLOW' color
    Then I check that there is a log for 'YELLOW' color
    When I unselect checkboxes necessary checkboxes
      | WATER |
      | WIND  |
    Then I check that there is a log for unselected checkboxes
      | WATER |
      | WIND  |