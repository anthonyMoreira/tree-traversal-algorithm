package com.anthony.tree_traversal_algorithm.algorithm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Consumer;

import com.anthony.tree_traversal_algorithm.tree.Node;
import com.anthony.tree_traversal_algorithm.tree.Tree;

public class DFSStrategy implements TraversalStrategy {

    @Override
    public Node findNode(String id, Tree tree, Consumer<Node> visitor) {
        Node root = tree.getRoot();
        Deque<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            var element = stack.pop();
            visitor.accept(element);
            if (element.id().equals(id)) {
                return element;
            } else {
                element.children().reversed().forEach(stack::addFirst);
            }
        }
        return null;
    }

}
