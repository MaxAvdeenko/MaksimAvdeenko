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
    # TODO It will be better if you create one single step, that can be used in order to open any kind of pages.
    When I open Different Elements Page
    Then I check that Different Elements page contains all need elements
    Then I check that Right section is displayed
    # TODO It might be possible(from business perspective) to select from 1 to 4
    # TODO nature elements at once, but in this method, you can select only 2,
    # TODO in the other words, it will be better with the list of the nature elements.
    When I click on checkboxes 'WATER' and 'WIND'
    Then I check that there is a log for 'WATER' and 'WIND' checkboxes
    When I click on radio 'SELEN'
    Then I check that there is a log for 'SELEN' radio
    When I click on colors dropdown
    When I select 'YELLOW' color
    Then I check that there is a log for 'YELLOW' color
    When I unselect checkboxes 'WATER' and 'WIND'
    Then I check that there is a log for 'WATER' and 'WIND' and they are unselected