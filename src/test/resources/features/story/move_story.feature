@story
Feature: Move story

  @saveDefaultStory @restoreDefaultStoryPosition @quitBrowser
  Scenario: Move a story from Current Iteration/Backlog panel to Icebox panel in a project
    Given I log in to Pivotal with Editable User credentials
    When I navigate to DASHBOARD_PAGE
      And I open the Default project in the dashboard
      And I move Default Story from Current Iteration/Backlog Panel to Icebox Panel
    Then the story should not be in the Current Iteration/Backlog Panel
      And the story should be in the Icebox Panel
    When I open the story from Icebox Panel
      And the story's name should not change
      And the story's id should not change