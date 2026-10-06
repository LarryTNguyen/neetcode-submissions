class Solution {
    List<List<Integer>> all = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(0,nums, new ArrayList<>());
        return all;
    }

    public void helper(int index, int[] nums, List<Integer> curr){
        if(index>= nums.length){
            all.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        helper(index+1, nums, curr);
        curr.removeLast();
        while(index+1<nums.length && nums[index+1] == nums[index]){
            index++;
        }
        helper(index+1, nums, curr);
    }
}
