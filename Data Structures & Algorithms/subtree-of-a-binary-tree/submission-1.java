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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(root.val == subRoot.val){
            if (isSame(root.left,subRoot.left) && isSame(root.right, subRoot.right)) return true;
            else return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
        }
        else{
            return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
        }
    }

    public boolean isSame(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        if((p!=null && q==null) || (p==null && q!=null)) return false;
        if(p.val != q.val) return false;
        return isSame(p.left,q.left) && isSame(p.right, q.right);
    }
}
