public class AddOneRowToTree623 {
    /*
     * Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.
        Note that the root node is at depth 1.
        The adding rule is:
        Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's
         left subtree root and right subtree root.
         cur's original left subtree should be the left subtree of the new left subtree root.
         cur's original right subtree should be the right subtree of the new right subtree root.
         If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val
          as the new root of the whole original tree, and the original tree is the new root's left subtree.
     */
    
     //Definition for a binary tree node.
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
        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            if (depth == 1) {
                TreeNode temp = new TreeNode(val) ;
                 temp.left = root ;
                return temp ;
            }
            return dfs(root , val , depth , 1); 
        }
        private TreeNode dfs(TreeNode node, int val, int d , int currDepth){
            if (node== null ) return null  ;
            if (currDepth +1 == d) {
                TreeNode TempL = node.left ;
                TreeNode TempR = node.right;

                node.left = new TreeNode(val) ;
                node.right = new TreeNode(val) ;

                node.left.left = TempL  ;
                node.right.right = TempR ;
            }

           node.left =  dfs(node.left, val, d, currDepth + 1); 
            node.right =  dfs(node.right, val, d, currDepth + 1); 

            return node ;
            
        }
    }
}
