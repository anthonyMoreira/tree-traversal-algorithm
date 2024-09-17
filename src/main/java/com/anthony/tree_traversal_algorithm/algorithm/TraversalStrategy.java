package com.anthony.tree_traversal_algorithm.algorithm;

import java.util.function.Consumer;

import com.anthony.tree_traversal_algorithm.tree.Node;
import com.anthony.tree_traversal_algorithm.tree.Tree;

public interface TraversalStrategy {
    Node findNode(String id, Tree tree, Consumer<Node> visitor);
}
