import java.util.ArrayList;

public class LevelOrderInSpiralForm {
    /*
     * Given a binary tree and the task is to find the spiral order traversal of the tree and return the list containing the elements.
        Spiral order Traversal mean: Starting from level 0 for root node, 
        for all the even levels we print the node's value from right to left 
        and for all the odd levels we print the node's value from left to right.
        
        For below tree, function should return [1, 2, 3, 4, 5, 6, 7]
     */

    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

class Solution {
    public ArrayList<Integer> findSpiral(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ArrayList<Node> queue = new ArrayList<>();
        queue.add(root);
        boolean leftToRight = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Node> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.remove(0);
                if (leftToRight) {
                    ans.add(node.data);
                } else {
                    temp.add(node);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (!leftToRight) {
                for (int i = temp.size() - 1; i >= 0; i--) {
                    ans.add(temp.get(i).data);
                }
            }
            leftToRight = !leftToRight;
        }
        return ans;
    }
}

}
