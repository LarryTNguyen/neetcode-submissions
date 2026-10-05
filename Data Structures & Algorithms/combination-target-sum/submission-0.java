class Solution {
    List<Integer> curSol = new ArrayList<>();
    List<List<Integer>> allSol = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
         helper(0,nums,target,curSol,allSol);
         return allSol;
    }

    public void helper(int index, int[]nums,int curr, List<Integer> curSol, List<List<Integer>> allSol){
        if(curr<=0 || index >= nums.length){
            if(curr==0 && index<=nums.length){
                allSol.add(new ArrayList<Integer>(curSol));
            }
            return;
        }
        curSol.add(nums[index]);
        helper(index, nums, curr-nums[index], curSol, allSol);
        curSol.removeLast();
        helper(index+1, nums, curr,curSol, allSol);
    }
}
