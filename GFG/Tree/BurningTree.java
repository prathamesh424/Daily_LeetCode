import java.util.* ;


public class BurningTree {
    /*
     * Given a binary tree and a target node, determine the minimum time required to burn the entire tree if the target node is set on fire.
     *  In one second, the fire spreads from a node to its left child, right child, and parent.
        Note: The tree contains unique values.
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
        public static int minTime(Node root, int target) {
            Map<Node, Node> parentMap = new HashMap<>();
            Queue<Node> queue = new LinkedList<>();
            Set<Node> visited = new HashSet<>();
            Node targetNode = null;
            queue.add(root);
            while (!queue.isEmpty()) {
                Node currentNode = queue.poll();
                if (currentNode.data == target) {
                    targetNode = currentNode;
                }
                if (currentNode.left != null) {
                    parentMap.put(currentNode.left, currentNode);
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    parentMap.put(currentNode.right, currentNode);
                    queue.add(currentNode.right);
                }
            }

            if (targetNode == null) {
                return 0;
            }
            
            int time = 0;
            queue.add(targetNode);
            visited.add(targetNode);

            while (!queue.isEmpty()) {
                int size = queue.size();
                boolean burned = false;

                for (int i = 0; i < size; i++) {
                    Node currentNode = queue.poll();

                    if (currentNode.left != null && !visited.contains(currentNode.left)) {
                        visited.add(currentNode.left);
                        queue.add(currentNode.left);
                        burned = true;
                    }
                    if (currentNode.right != null && !visited.contains(currentNode.right)) {
                        visited.add(currentNode.right);
                        queue.add(currentNode.right);
                        burned = true;
                    }
                    Node parent = parentMap.get(currentNode);
                    if (parent != null && !visited.contains(parent)) {
                        visited.add(parent);
                        queue.add(parent);
                        burned = true;
                    }
                }
                if (burned) {
                    time++;
                }
            }

            return time;        
        }
    }

}
