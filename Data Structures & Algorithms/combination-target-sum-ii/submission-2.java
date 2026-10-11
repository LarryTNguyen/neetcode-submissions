class Solution {
    List<List<Integer>> all = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(0, candidates, target, new ArrayList<>());
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
        helper(index+1, nums, target-nums[index],curr);
        curr.removeLast();
        while(index+1 != nums.length && nums[index+1] == nums[index]){
            index++;
        }
        helper(index+1, nums, target, curr);
    }
}
