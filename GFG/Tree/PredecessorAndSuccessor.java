import java.util.*;



public class PredecessorAndSuccessor {
    /*
     * You are given root node of the BST and an integer key. 
     * You need to find the in-order successor and predecessor of the given key. 
     * If either predecessor or successor is not found, then set it to NULL.
        Note:- In an inorder traversal the number just smaller than the target is the predecessor 
        and the number just greater than the target is the successor. 
     */

    
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
} 

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        ArrayList<Node> result = new ArrayList<>();
        Node predecessor = null;
        Node successor = null;
        Node current = root;
        while (current != null) {
            if (current.data == key) {
                if (current.left != null) {
                    Node temp = current.left;
                    while (temp.right != null) {
                        temp = temp.right;
                    }
                    predecessor = temp;
                }
                if (current.right != null) {
                    Node temp = current.right;
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    successor = temp;
                }
                break;
            } else if (current.data > key) {
                successor = current;
                current = current.left;
            } else {
                predecessor = current;
                current = current.right;
            }
        }
        result.add(predecessor);
        result.add(successor);
        return result;   

    }
}
}
