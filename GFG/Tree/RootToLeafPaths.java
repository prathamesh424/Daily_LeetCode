import java.util.ArrayList;

public class RootToLeafPaths {
    /*
     * Given a Binary Tree, you need to find all the possible paths from the root node to all the leaf nodes of the binary tree.
    
        Note: The paths should be returned such that paths from the left subtree of any node are listed first,
                 followed by paths from the right subtree.
     */

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    class Solution {
        public static ArrayList<ArrayList<Integer>> Paths(Node root) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            ArrayList<Integer> path = new ArrayList<>();
            findPaths(root, path, result);
            return result;
        }

        private static void findPaths(Node node, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
            if (node == null) {
                return;
            }
            path.add(node.data);
            if (node.left == null && node.right == null) {
                result.add(new ArrayList<>(path));
            } else {
                findPaths(node.left, path, result);
                findPaths(node.right, path, result);
            }
            path.remove(path.size() - 1); 
        }
    }

}
