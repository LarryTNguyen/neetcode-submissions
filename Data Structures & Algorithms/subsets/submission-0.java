class Solution {
    List<List<Integer>> allSubsets = new ArrayList<>();
    ArrayList<Integer> current = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subsetCreator(0, nums, current, allSubsets);
        return allSubsets;
    }

    public void subsetCreator(int index, int[] nums, List<Integer> current, 
            List<List<Integer>> allSubsets){
        if(index >= nums.length){
            allSubsets.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        subsetCreator(index + 1, nums, current, allSubsets);
        current.removeLast();
        subsetCreator(index+1, nums, current, allSubsets);
    }
}
