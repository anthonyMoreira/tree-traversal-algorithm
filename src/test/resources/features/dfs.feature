Feature: Traverse the tree from the depth first
  Scenario: The children node should have more priority than the siblings of the node
    Given The Tree T has one root A, one leaf B and C. B has children D and E.
    When searching node D in a DFS strategy
    Then node C is never visited
    And the correct order of visit is root->B->D