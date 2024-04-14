public class SumOfLeftLeaves404 {


    /*Given the root of a binary tree, return the sum of all left leaves.
        A leaf is a node with no children. A left leaf is a leaf that is the left child of another node. */

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
    public int cnt=0 ;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0 ;
        sumOfLeftLeaves(root.left) ;
        if (root.left != null ) {
            if (root.left.left == null && root.left.right == null){
                cnt += root.left.val ;
            }
        }
        sumOfLeftLeaves(root.right) ;
        return cnt ;
    }
}
}
