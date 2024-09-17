Feature: Traverse the tree from the breadth first
  Scenario: For a given tree, try to find one of the bottom leaf
    Given The Tree T has one root, one leaf B and C. B has children D and E.
    When searching node D in a BFS Strategy
    Then the correct order of visit is root->B->C->D