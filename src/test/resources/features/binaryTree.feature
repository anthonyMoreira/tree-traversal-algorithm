Feature: Binary tree is a new kind of tree with 2 children max
  Scenario: When adding more than 2 children an error is raised
    Given a tree with root A
    When adding 3 children to root A an exception is raised