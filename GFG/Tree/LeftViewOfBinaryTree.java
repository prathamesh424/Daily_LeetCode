import java.util.ArrayList;

public class LeftViewOfBinaryTree {
   
    /*
     * You are given the root of a binary tree. 
     * Your task is to return the left view of the binary tree. 
     * The left view of a binary tree is the set of nodes visible when the tree is viewed from the left side.
    If the tree is empty, return an empty list.
     */

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class Solution {
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        leftView(root, 0, result);
        return result;
    }

    void leftView(Node node, int level, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }
        if (level == result.size()) {
            result.add(node.data);
        }
        leftView(node.left, level + 1, result);
        leftView(node.right, level + 1, result);
    }
}
}
