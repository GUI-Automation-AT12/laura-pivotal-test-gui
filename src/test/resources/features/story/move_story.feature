Feature: Move story

  @saveDefaultStory @restoreDefaultStoryPosition
  Scenario: Move a story from Current Iteration/Backlog to Icebox panel in a project
    Given I log in to Pivotal with Editable User credentials
    When I navigate to DASHBOARD_PAGE
      And I open the Default project in the dashboard
      And I move Default Story from Current Iteration/Backlog Panel to Icebox Panel
    Then Default Story should not be in the Current Iteration/Backlog Panel
      And the Default Story should be in the Icebox Panel
    When I open the Default Story from Icebox Panel
      And the Default Story's name should not change
      And the Default Story's id should not change