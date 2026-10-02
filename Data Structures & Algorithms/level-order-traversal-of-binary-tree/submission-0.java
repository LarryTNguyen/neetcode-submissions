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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root!=null) queue.offer(root);
        int levelNum = 0;
        while(queue.size() > 0){
            int levelSize = queue.size();
            List<Integer> newLevel = new ArrayList<>();
            for(int i = 0; i < levelSize; i++){
                TreeNode curr = queue.poll();
                newLevel.add(curr.val);
                if(curr.left!=null)queue.offer(curr.left);
                if(curr.right!=null)queue.offer(curr.right);
            }
            result.add(newLevel);
            levelNum++;
        }
        return result;
    }
}
