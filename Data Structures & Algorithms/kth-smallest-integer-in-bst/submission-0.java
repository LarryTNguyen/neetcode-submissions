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
    int count = 0;
    int answer;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorderTraverse(root);
        return answer;
    }

    public void inorderTraverse(TreeNode root){
        if (root == null) return;
        inorderTraverse(root.left);
        count--;
        if(count==0){
            answer = root.val;
            return;
        }
        inorderTraverse(root.right);
    }
}
