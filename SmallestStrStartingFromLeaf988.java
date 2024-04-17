public class SmallestStrStartingFromLeaf988 {

    /*
     * You are given the root of a binary tree where each node has a value in the range [0, 25] representing the letters 'a' to 'z'.
        Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
        As a reminder, any shorter prefix of a string is lexicographically smaller.
            For example, "ab" is lexicographically smaller than "aba".
            A leaf of a node is a node that has no children.
    */



    // Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
    }

    class Solution {
        public String smallestFromLeaf(TreeNode root) {
            StringBuilder smallest = new StringBuilder();
            dfs(root, new StringBuilder(), smallest);
            return smallest.toString();
        }
        
        private void dfs(TreeNode node, StringBuilder path, StringBuilder smallest) {
            if (node == null) return;
            
            path.append((char)('a' + node.val));
            
            if (node.left == null && node.right == null) {
                String currentString = path.reverse().toString();
                if (smallest.length() == 0 || currentString.compareTo(smallest.toString()) < 0) {
                    smallest.setLength(0);
                    smallest.append(currentString);
                }
                path.reverse();
            }
            
            
            dfs(node.left, path, smallest);
            dfs(node.right, path, smallest);
            
            path.setLength(path.length() - 1);
        }
    }

}
