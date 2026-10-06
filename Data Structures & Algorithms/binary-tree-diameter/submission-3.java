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
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        int depthL = maxDepth(root.left);
        int depthR = maxDepth(root.right);
        int diameter = depthL + depthR;
        maxDiameter = Math.max(diameter, maxDiameter);
        return 1 + Math.max(depthL, depthR);
    }
}
