package com.anthony.tree_traversal_algorithm.tree;

import java.util.function.Consumer;

import com.anthony.tree_traversal_algorithm.algorithm.TraversalStrategy;

public interface Tree {
    Node getRoot();

    void setRoot(Node root);

    Node findNode(String id);
    Node findNode(String id, Consumer<Node> visitor);

    void addToNode(Node node, Node childNode);

    void setTraversalStrategy(TraversalStrategy strategy);
}
