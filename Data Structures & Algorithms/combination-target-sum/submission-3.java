class Solution {
    List<List<Integer>> all = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        helper(0, nums, target, new ArrayList<>());
        return all;
    }

    public void helper(int index, int[] nums, int target, List<Integer> curr){
        if(target == 0){
            all.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0 || index == nums.length){
            return;
        }
        curr.add(nums[index]);
        helper(index, nums, target-nums[index], curr);
        curr.removeLast();
        helper(index+1, nums, target, curr);
    }
}
