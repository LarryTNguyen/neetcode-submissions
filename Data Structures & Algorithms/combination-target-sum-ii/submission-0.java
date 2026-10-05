class Solution {
    List<Integer> curSol = new ArrayList<>();
    List<List<Integer>> allSol = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        helper(0,nums,target,curSol);
        return allSol;
    }

    public void helper(int index, int[]nums,int curr, List<Integer> curSol){
        if(curr<=0 || index >= nums.length){
            if(curr==0){
                allSol.add(new ArrayList<Integer>(curSol));
            }
            return;
        }
        curSol.add(nums[index]);
        helper(index+1, nums, curr-nums[index], curSol);
        curSol.removeLast();
        while(index+1<nums.length && nums[index]==nums[index+1]){
            index++;
        }
        helper(index+1, nums, curr,curSol);
    }
}
