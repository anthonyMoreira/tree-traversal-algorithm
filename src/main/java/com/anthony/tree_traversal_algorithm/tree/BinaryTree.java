package com.anthony.tree_traversal_algorithm.tree;

import java.util.ArrayList;
import java.util.function.Consumer;

import com.anthony.tree_traversal_algorithm.algorithm.DFSStrategy;
import com.anthony.tree_traversal_algorithm.algorithm.TraversalStrategy;

public class BinaryTree implements Tree {
    private TraversalStrategy traversalStrategy = new DFSStrategy();
    private Node root = new Node(new ArrayList<>(), null, "root");

    @Override
    public Node getRoot() {
        return root;
    }

    @Override
    public void setRoot(Node root) {
        this.root = root;
    }

    @Override
    public Node findNode(String id) {
        return traversalStrategy.findNode(id, this, (n) -> {});
    }

    @Override
    public Node findNode(String id, Consumer<Node> visiter) {
        return traversalStrategy.findNode(id, this, visiter);
    }

    @Override
    public void addToNode(Node node, Node childNode) {
        if (node.children().size() >= 2) {
            throw new IllegalArgumentException("More than two leaves are not allowed in a binary tree");
        }
        node.children().add(childNode);
    }

    @Override
    public void setTraversalStrategy(TraversalStrategy strategy) {
        this.traversalStrategy = strategy;
    }
}
