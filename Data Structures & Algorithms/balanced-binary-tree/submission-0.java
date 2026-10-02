/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return balanced;
    }

    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        int dLeft = maxDepth(root.left);
        int dRight = maxDepth(root.right);
        if(Math.abs(dLeft - dRight) > 1)balanced = false;
        return 1 + Math.max(dLeft , dRight);
    }
}
