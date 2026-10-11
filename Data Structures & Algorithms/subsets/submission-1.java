class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        helper(0, nums, new ArrayList<>(), all);
        return all;
    }

    public void helper (int index, int[] nums, List<Integer> curr, List<List<Integer>> all){
        if(index == nums.length){
            all.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[index]);
        helper(index+1, nums, curr, all);
        curr.removeLast();
        helper(index+1, nums, curr, all);
    }
}
