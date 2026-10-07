class Solution {
    List<Integer> curSol = new ArrayList<>();
    List<List<Integer>> allSol = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
         helper(0,nums,target,curSol);
         return allSol;
    }

    public void helper(int index, int[]nums,int curr, List<Integer> curSol){
        // if(curr<=0 || index >= nums.length){
        //     if(curr==0 && index<=nums.length){
        //         allSol.add(new ArrayList<Integer>(curSol));
        //     }
        //     return;
        // }
        if(curr == 0){
            allSol.add(new ArrayList<Integer>(curSol));
            return;
        }
        if(curr<0 || index >= nums.length){
            return;
        }
        curSol.add(nums[index]);
        helper(index, nums, curr-nums[index], curSol);
        curSol.removeLast();
        helper(index+1, nums, curr,curSol);
    }
}
