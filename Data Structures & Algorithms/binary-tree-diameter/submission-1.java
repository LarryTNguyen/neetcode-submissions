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
        if(root == null) return 0;
        int diameter = maxDepth(root.left) + maxDepth(root.right);
        if(diameter>maxDiameter) maxDiameter = diameter;
        return maxDiameter;
    }

    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        int depthLeft = maxDepth(root.left);
        int depthRight = maxDepth(root.right);
        int diameter = depthLeft + depthRight;
        if(diameter>maxDiameter) maxDiameter = diameter;
        return 1 + Math.max(depthLeft,depthRight);
    }
}
