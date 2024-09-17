package com.anthony.tree_traversal_algorithm.tree;

import java.util.List;

public record Node(List<Node> children, Node parent, String id) {
}
