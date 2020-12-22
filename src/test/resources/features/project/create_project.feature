Feature: Create project

  @deleteProject
  Scenario: Create a private project in HomePage
    Given I log in to Pivotal with Editable User credentials
    When I open the create project dialog in projects tab
      And I edit the Project Form with the following information
        | Project Name    | demo     |
        | Account         | Untitled |
        | Project privacy | Private  |
#      And I select the untitled account in the account selector Dropdown menu
#      And I select the private option in Project Privacy section
#    Then the user should be redirected to the created project dashboard
#      And the name of created project should be visible in the header of the page