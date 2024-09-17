package com.anthony.tree_traversal_algorithm.cucumber;

import java.util.ArrayList;
import java.util.List;

import com.anthony.tree_traversal_algorithm.algorithm.BFSStrategy;
import com.anthony.tree_traversal_algorithm.tree.BinaryTree;
import com.anthony.tree_traversal_algorithm.tree.Node;
import com.anthony.tree_traversal_algorithm.tree.Tree;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class BFSTest {

    private final Node C = new Node(new ArrayList<>(), null, "C");
    private final Node B = new Node(new ArrayList<>(), null, "B");
    private final Node D = new Node(new ArrayList<>(), null, "D");
    private final List<Node> visitedNode = new ArrayList<>();
    private Tree tree;

    @Given("The Tree T has one root, one leaf B and C. B has children D and E.")
    public void theTreeTHasOneRootOneLeafBAndCBHasChildrenDAndE() {
        tree = new BinaryTree();
        tree.setTraversalStrategy(new BFSStrategy());
        tree.addToNode(tree.getRoot(), B);
        tree.addToNode(tree.getRoot(), C);

        tree.addToNode(B, D);
        Node e = new Node(new ArrayList<>(), null, "E");
        tree.addToNode(B, e);
    }

    @When("searching node D in a BFS Strategy")
    public void whenSearchingNodeD() {
        var node = tree.findNode("D", visitedNode::add);
        Assertions.assertThat(node).isNotNull();
    }

    @Then("the correct order of visit is root->B->C->D")
    public void theCorrectOrderOfVisitIsRootBCD() {
        Assertions.assertThat(visitedNode.indexOf(tree.getRoot())).isEqualTo(0);
        Assertions.assertThat(visitedNode.indexOf(B)).isEqualTo(1);
        Assertions.assertThat(visitedNode.indexOf(C)).isEqualTo(2);
        Assertions.assertThat(visitedNode.indexOf(D)).isEqualTo(3);
    }

}
