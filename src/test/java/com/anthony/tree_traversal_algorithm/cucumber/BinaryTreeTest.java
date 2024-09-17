package com.anthony.tree_traversal_algorithm.cucumber;

import java.util.ArrayList;
import java.util.stream.IntStream;

import com.anthony.tree_traversal_algorithm.tree.BinaryTree;
import com.anthony.tree_traversal_algorithm.tree.Node;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class BinaryTreeTest {
    private final BinaryTree binaryTree = new BinaryTree();

    @Given("a tree with root A")
    public void aTreeWithRootA() {

        binaryTree.setRoot(new Node(new ArrayList<>(), null, "root"));
    }

    @When("adding {int} children to root A an exception is raised")
    public void addingChildrenToRootA(int children) {
        Assertions.assertThatThrownBy(() -> {
            IntStream.rangeClosed(0, children)
                .forEach(i -> binaryTree.addToNode(binaryTree.getRoot(),
                                                   new Node(new ArrayList<>(),
                                                            binaryTree.getRoot(),
                                                            String.valueOf(i))));
        }).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThat(binaryTree.getRoot().children().size())
            .isEqualTo(2);
    }

}
