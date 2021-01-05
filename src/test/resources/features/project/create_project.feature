Feature: Create project

  @deleteProject
  Scenario: Create a private project in HomePage
    Given I log in to Pivotal with Editable User credentials
    When I open the create project dialog in projects tab
      And I edit the Project Form with the following information
        | Project Name    | demo UNIQUE_ID |
        | Account         | Untitled |
        | Project privacy | Private  |
    Then the user should be redirected to the created project dashboard
      And the name of created project should be visible in the header of the page